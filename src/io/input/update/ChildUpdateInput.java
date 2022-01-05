package io.input.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import enums.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ChildUpdateInput {
    @JsonProperty(Constants.ID)
    private @Getter @Setter int id;

    @JsonProperty(Constants.NICE_SCORE)
    private @Getter @Setter Double niceScore;

    @JsonProperty(Constants.GIFTS_PREFERENCES)
    private @Getter @Setter List<Category> giftsPreferences;

    public ChildUpdateInput() { }
}
