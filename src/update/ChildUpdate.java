package update;

import enums.Category;
import enums.ElvesType;
import io.input.update.ChildUpdateInput;

import java.util.ArrayList;
import java.util.List;

public class ChildUpdate {
    private final int id;
    private final Double niceScore;
    private final List<Category> giftsPreferences;
    private final ElvesType elfType;

    public ChildUpdate(final int id, final Double niceScore,
                       final List<Category> giftsPreferences,
                       final ElvesType elfType) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = new ArrayList<>(giftsPreferences);
        this.elfType = elfType;
    }

    public ChildUpdate(final ChildUpdateInput childUpdateInput) {
        this(
                childUpdateInput.getId(),
                childUpdateInput.getNiceScore(),
                childUpdateInput.getGiftsPreferences(),
                childUpdateInput.getElf()
        );
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

    public final ElvesType getElfType() {
        return elfType;
    }
}
