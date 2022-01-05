package update;

import child.Child;
import database.DatabaseTrackable;
import gift.Gift;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class AnnualUpdate implements DatabaseTrackable {
    /* Is incremented with each new AnnualUpdate. */
    private static int globalID = 0;

    /* Global ID used as primary key for the database. */
    private final int id;
    private @Getter Double newSantaBudget;
    private @Getter ArrayList<Gift> newGifts;
    private @Getter ArrayList<Child> newChildren;
    private @Getter ArrayList<ChildUpdate> childrenUpdates;

    public AnnualUpdate(final Double newSantaBudget, final List<Gift> newGifts,
                        final List<Child> newChildren,
                        final List<ChildUpdate> childrenUpdates) {
        id = globalID++;
        this.newSantaBudget = newSantaBudget;
        this.newGifts = new ArrayList<>(newGifts);
        this.newChildren = new ArrayList<>(newChildren);
        this.childrenUpdates = new ArrayList<>(childrenUpdates);
    }

    @Override
    public String getKey() {
        return String.valueOf(id);
    }
}
