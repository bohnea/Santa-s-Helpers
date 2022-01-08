package main;

import child.Child;
import child.ChildManager;
import common.Constants;
import database.Database;
import database.managers.search.SearchManager;
import enums.Category;
import enums.CityStrategyEnum;
import gift.Gift;
import io.output.AnnualOutput;
import io.output.Output;
import io.output.child.ChildOutput;
import io.output.child.ChildOutputFactory;
import update.AnnualUpdate;
import update.assignmentstrategy.AssignmentStrategy;
import update.assignmentstrategy.AssignmentStrategyFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SantaTracker implements ChildObservable {
    private final int numberOfYears;
    private Double santaBudget;
    private final Map<Integer, Double> childrenBudgets;

    public SantaTracker(final int numberOfYears, final Double santaBudget) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        childrenBudgets = new HashMap<>();
    }

    /**
     * Adds the average scores of all the given children, strictly in order, from left to right.
     * @param children the list of children
     * @return the sum of the children's average scores
     */
    private Double getSumOfAverageScores(final List<Child> children) {
        // Declare the sum
        double sum = 0.0d;

        // Iterate through the entire list
        for (Child child : children) {
            sum += child.getAverageScore();
        }

        // Return the sum
        return sum;
    }

    /**
     * Removes all young adults from the database.
     */
    private void removeYoungAdults() {
        // Get the children from the database
        List<Child> children = new ArrayList<>(SearchManager.getChildrenFromDatabase());

        // Go through each child and keep the young adults
        children.removeIf(child -> child.getAge() <= Constants.TEEN_MAX_AGE);

        // For each young adult, look them up in the database and remove them
        children.forEach(
                youngAdult -> Database.getInstance().removeEntity(Child.class, youngAdult.getKey())
        );
    }

    /**
     * Goes through all the children in the database and calculates their allocated budgets,
     * storing the results in the childrenBudgets map.
     */
    private void updateChildrenBudgets() {
        // Get the children from the database
        List<Child> children = SearchManager.getChildrenFromDatabase();

        // Compute the budget unit
        Double budgetUnit = santaBudget / getSumOfAverageScores(children);

        // Clear the previous children budgets
        childrenBudgets.clear();

        // For each child, calculate his allocated budget
        children.forEach(
                child -> childrenBudgets.put(
                        child.getId(),

                        // Multiply the child average score by the budget unit
                        // and apply Elf modifications
                        child.getElf().applyBudgetModifier(
                                child.getAverageScore() * budgetUnit
                        )
                )
        );
    }

    /**
     * Small-scale observer pattern which updates all children in the database when
     * a new annual update takes place.
     */
    public void notifyObservers() {
        // Get all children and notify them
        SearchManager.getChildrenFromDatabase().forEach(Child::update);
    }

    /**
     * Offers the gifts to the given child.
     * @param child the child to receive the gifts
     * @param allocatedBudget the maximum budget of the gifts
     * @return a list of received gifts
     */
    private List<Gift> offerGiftsToChild(final Child child, final Double allocatedBudget) {
        // Create a list of all the received gifts
        List<Gift> receivedGifts = new ArrayList<>();

        // Keep track of the current sum
        double currentSum = 0.0d;

        // Go through the child's preferred categories
        for (Category category: child.getGiftsPreference()) {
            // Get the cheapest gift of the category
            Gift giftToOffer = SearchManager.getCheapestGiftOfCategory(category, true);

            // Check if the gift is null, or it's outside the budget
            if (giftToOffer == null || currentSum + giftToOffer.getPrice() > allocatedBudget) {
                continue;
            }

            // Offer the gift to the child
            currentSum += giftToOffer.getPrice();
            receivedGifts.add(giftToOffer);

            // Reduce the gift's quantity
            giftToOffer.reduceQuantity();
        }

        // Apply elf gift modifier if the receivedGifts list is empty
        if (receivedGifts.isEmpty()) {
            receivedGifts.addAll(child.getElf().applyExtraGifts(child));
        }

        // Return the list of received gifts
        return receivedGifts;
    }

    /**
     * Starts the gift offering process.
     * @param assignmentStrategy the order in which to assign gifts to children
     * @return the current year's output
     */
    private AnnualOutput offerGiftsToAll(final AssignmentStrategy assignmentStrategy) {
        // Remove children over 18 years old
        removeYoungAdults();

        // Update santa's individual child budget
        updateChildrenBudgets();

        // Create a list of all the children who will receive presents
        List<ChildOutput> childOutput = new ArrayList<>();

        // Go through each child, in the specified order, and offer him the gifts
        for (Child child: assignmentStrategy.getChildOrder()) {
            // Get the child's received gifts
            List<Gift> receivedGifts =
                    offerGiftsToChild(child, childrenBudgets.get(child.getId()));

            // Add the result to the list
            childOutput.add(ChildOutputFactory.createChildOutput(
                    child,
                    childrenBudgets.get(child.getId()),
                    receivedGifts
            ));
        }

        // Sort the ChildOutput list by ID
        childOutput.sort(Comparator.comparingInt(ChildOutput::getId));

        // Return the current year's output
        return new AnnualOutput(childOutput);
    }

    private void updateGiftInDatabase(final Gift gift) {
        // Attempt to retrieve the gift from the database
        Gift retrievedGift =
                (Gift) Database.getInstance().retrieveEntity(Gift.class, gift.getKey());

        // If not found, add the gift to the database
        if (retrievedGift == null) {
            Database.getInstance().add(List.of(gift));
            return;
        }

        // Otherwise, update the quantity
        retrievedGift.addQuantity(gift.getQuantity());
    }

    /**
     * Simulates a new yearly round. Notifies children of the year change, updates the
     * information with the new values and offers gifts to the children.
     * @param annualUpdate the annual update to be executed
     * @return the results of the current year, as an AnnualOutput object
     */
    private AnnualOutput advanceYear(final AnnualUpdate annualUpdate) {
        // Notify all children of the year change
        notifyObservers();

        // Add the new children
        Database.getInstance().add(annualUpdate.getNewChildren());

        // Create a new ChildManager
        ChildManager childManager = new ChildManager();

        // Apply childUpdates
        annualUpdate.getChildrenUpdates().forEach(childManager::applyChildUpdate);

        // Add the new gifts
        annualUpdate.getNewGifts().forEach(this::updateGiftInDatabase);

        // Set the new budget
        santaBudget = annualUpdate.getNewSantaBudget();

        // Offer the gifts to the children, in the order specified in the
        // annual update, and return the output
        return offerGiftsToAll(annualUpdate.getStrategy());
    }

    /**
     * Starts the Christmas simulation. Performs round 0 initialization and executes
     * every annual update, in order of apparition in the database.
     * @return the final results of the entire simulation, as an Output object
     */
    public Output startSimulation() {
        // Create a list of annual outputs
        List<AnnualOutput> annualOutputs = new ArrayList<>();

        // Offer initial gifts, in order of child IDs, and add the results to the list
        annualOutputs.add(offerGiftsToAll(
                AssignmentStrategyFactory.createGiftStrategy(CityStrategyEnum.ID)
        ));

        // Get all annual updates
        SearchManager.getAnnualUpdatesFromDatabase()
                // Because test 7 has fewer years than it actually has...
                .subList(0, numberOfYears)
                // Execute each annual update and add the results to the list
                .forEach(annualUpdate -> annualOutputs.add(advanceYear(annualUpdate)));

        // Create a new Output object from the annual results
        return new Output(annualOutputs);
    }
}
