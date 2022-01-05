package main;

import child.Child;
import child.ChildManager;
import database.Database;
import database.SearchManager;
import enums.Category;
import gift.Gift;
import io.output.AnnualOutput;
import io.output.Output;
import io.output.child.ChildOutput;
import io.output.child.ChildOutputFactory;
import update.AnnualUpdate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SantaTracker {
    /**
     * The Singleton instance.
     */
    private static SantaTracker instance = null;

    private SantaTracker() {
        childrenBudgets = new HashMap<>();
    }

    /**
     * Gets the instance of the SantaTracker Singleton, if it exists, or creates a new one.
     * @return the Singleton instance
     */
    public static SantaTracker getInstance() {
        if (instance == null) {
            instance = new SantaTracker();
        }

        return instance;
    }

    private int numberOfYears;
    private Double santaBudget;
    private final Map<Integer, Double> childrenBudgets;

    public void initialize(final int numberOfYears, final Double santaBudget) {
        // Set the initial data
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
    }

    private Double getSumOfAverageScores(final List<Child> children) {
        // Declare the sum
        Double sum = 0.0d;

        // Iterate through the entire list
        for (Child child : children) {
            sum += child.getAverageScore();
        }

        // Return the sum
        return sum;
    }

    private void removeYoungAdults() {
        // Get the children from the database
        List<Child> children = new ArrayList<>(SearchManager.getChildrenFromDatabase());

        // Go through each child and keep the young adults
        children.removeIf(child -> child.getAge() <= 18);

        // For each young adult, look them up in the database and remove them
        children.forEach(
                youngAdult -> Database.getInstance().removeEntity(Child.class, youngAdult.getKey())
        );
    }

    private void updateChildrenBudgets() {
        // Get the children from the database
        List<Child> children = SearchManager.getChildrenFromDatabase();

        // Compute the budget unit
        Double budgetUnit = santaBudget / getSumOfAverageScores(children);

        // Clear the previous children budgets
        childrenBudgets.clear();

        // For each child, calculate his allocated budget
        children.forEach(
                child -> childrenBudgets.put(child.getId(), child.getAverageScore() * budgetUnit)
        );
    }

    /**
     * Small-scale observer pattern which updates all children in the database when
     * a new annual update takes place.
     */
    private void notifyChildren() {
        // Get all children and notify them
        SearchManager.getChildrenFromDatabase().forEach(Child::update);
    }

    private List<Gift> offerGiftsToChild(final Child child, final Double allocatedBudget) {
        // Create a list of all the received gifts
        List<Gift> receivedGifts = new ArrayList<>();

        // Keep track of the current sum
        Double currentSum = 0.0d;

        // Go through the child's preferred categories
        for (Category category: child.getGiftsPreference()) {
            // Get the cheapest gift of the category
            Gift giftToOffer = SearchManager.getCheapestGiftOfCategory(category);

            // Check if the gift is null, or it's outside the budget
            if (giftToOffer == null || currentSum + giftToOffer.getPrice() > allocatedBudget) {
                continue;
            }

            // Offer the gift to the child
            currentSum += giftToOffer.getPrice();
            receivedGifts.add(giftToOffer);
        }

        return receivedGifts;
    }

    private AnnualOutput offerGiftsToAll() {
        // Remove children over 18 years old
        removeYoungAdults();

        // Update santa's individual child budget
        updateChildrenBudgets();

        // Create a list of all the children who will receive presents
        List<ChildOutput> childOutput = new ArrayList<>();

        // Go through each child and offer him the gifts
        for (Child child: SearchManager.getChildrenFromDatabase()) {
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

        // Return the current year's output
        return new AnnualOutput(childOutput);
    }

    private AnnualOutput advanceYear(AnnualUpdate annualUpdate) {
        // Notify all children of the year change
        notifyChildren();

        // Add the new children
        Database.getInstance().add(annualUpdate.getNewChildren());

        // Create a new ChildManager
        ChildManager childManager = new ChildManager();

        // Apply childUpdates
        annualUpdate.getChildrenUpdates().forEach(childManager::applyChildUpdate);

        // Add the new gifts
        Database.getInstance().add(annualUpdate.getNewGifts());

        // Set the new budget
        santaBudget = annualUpdate.getNewSantaBudget();

        // Offer the gifts to the children and return the output
        return offerGiftsToAll();
    }

    public Output startSimulation() {
        // Create a list of annual outputs
        List<AnnualOutput> annualOutputs = new ArrayList<>();

        // Offer initial gifts and add the results to the list
        annualOutputs.add(offerGiftsToAll());

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
