package update;

import enums.Category;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ChildUpdate {
    private final @Getter int id;
    private final @Getter Double niceScore;
    private final @Getter List<Category> giftsPreferences;

    public ChildUpdate(final int id, final Double niceScore,
                       final List<Category> giftsPreferences) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = new ArrayList<>(giftsPreferences);
    }
}
