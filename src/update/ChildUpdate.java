package update;

import enums.Category;
import enums.ElvesType;

import java.util.ArrayList;
import java.util.List;

public class ChildUpdate {
    private final int id;
    private final Double niceScore;
    private final List<Category> giftsPreferences;
    private final ElvesType elf;

    public ChildUpdate(final int id, final Double niceScore,
                       final List<Category> giftsPreferences,
                       final ElvesType elf) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = new ArrayList<>(giftsPreferences);
        this.elf = elf;
    }

    public final int getId() {
        return id;
    }

    public final Double getNiceScore() {
        return niceScore;
    }

    public final List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public final ElvesType getElf() {
        return elf;
    }
}
