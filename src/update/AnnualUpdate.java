package update;

import child.Child;
import database.DatabaseTrackable;
import enums.CityStrategyEnum;
import gift.Gift;

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
    private CityStrategyEnum strategy;

    public AnnualUpdate(final Double newSantaBudget, final List<Gift> newGifts,
                        final List<Child> newChildren,
                        final List<ChildUpdate> childrenUpdates,
                        final CityStrategyEnum strategy) {
        // Set the instance's ID to the current global ID, then increment the global ID
        id = globalID++;

        // Set the default values
        this.newSantaBudget = newSantaBudget;
        this.newGifts = new ArrayList<>(newGifts);
        this.newChildren = new ArrayList<>(newChildren);
        this.childrenUpdates = new ArrayList<>(childrenUpdates);
        this.strategy = strategy;
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

    public final CityStrategyEnum getStrategy() {
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
