package io.input.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import enums.Category;

import java.util.List;

/**
 * Class created for JSON parsing.
 */
public class ChildUpdateInput {
    @JsonProperty(Constants.ID)
    private int id;

    @JsonProperty(Constants.NICE_SCORE)
    private Double niceScore;

    @JsonProperty(Constants.GIFTS_PREFERENCES)
    private List<Category> giftsPreferences;

    public ChildUpdateInput() { }

    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final Double getNiceScore() {
        return niceScore;
    }

    public final void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public final List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public final void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
}
