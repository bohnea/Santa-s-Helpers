package update;

import child.Child;
import database.DatabaseTrackable;
import gift.Gift;
import io.input.update.AnnualUpdateInput;
import update.assignmentstrategy.AssignmentStrategy;
import update.assignmentstrategy.AssignmentStrategyFactory;

import java.util.ArrayList;
import java.util.List;

public class AnnualUpdate implements DatabaseTrackable {
    /* Global ID incremented with each new AnnualUpdate. */
    private static int globalID = 0;

    /* Individual ID used as primary key for the database. */
    private final int id;
    private Double newSantaBudget;
    private ArrayList<Gift> newGifts;
    private ArrayList<Child> newChildren;
    private ArrayList<ChildUpdate> childrenUpdates;
    private AssignmentStrategy strategy;

    public AnnualUpdate(final Double newSantaBudget, final List<Gift> newGifts,
                        final List<Child> newChildren,
                        final List<ChildUpdate> childrenUpdates,
                        final AssignmentStrategy strategy) {
        // Set the instance's ID to the current global ID, then increment the global ID
        id = globalID++;

        // Set the default values
        this.newSantaBudget = newSantaBudget;
        this.newGifts = new ArrayList<>(newGifts);
        this.newChildren = new ArrayList<>(newChildren);
        this.childrenUpdates = new ArrayList<>(childrenUpdates);
        this.strategy = strategy;
    }

    public AnnualUpdate(final AnnualUpdateInput annualUpdateInput) {
        this(
                annualUpdateInput.getNewSantaBudget(),
                annualUpdateInput.getNewGifts().stream()
                        .map(Gift::new).toList(),
                annualUpdateInput.getNewChildren().stream()
                        .map(Child.Builder::new).map(Child.Builder::build).toList(),
                annualUpdateInput.getChildrenUpdates().stream()
                        .map(ChildUpdate::new).toList(),
                AssignmentStrategyFactory.createGiftStrategy(annualUpdateInput.getStrategy())
        );
    }

    public final int getId() {
        return id;
    }

    public final Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public final ArrayList<Gift> getNewGifts() {
        return newGifts;
    }

    public final ArrayList<Child> getNewChildren() {
        return newChildren;
    }

    public final ArrayList<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }

    public final AssignmentStrategy getStrategy() {
        return strategy;
    }

    /**
     * Gets the primary key, for use with the database.
     * @return the primary key
     */
    @Override
    public final String getKey() {
        return String.valueOf(id);
    }
}
