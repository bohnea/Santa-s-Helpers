package io;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import enums.Category;
import enums.Cities;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ChildInput {
    @JsonProperty(Constants.ID)
    private @Getter @Setter Integer id;

    @JsonProperty(Constants.LAST_NAME)
    private @Getter @Setter String lastName;

    @JsonProperty(Constants.FIRST_NAME)
    private @Getter @Setter String firstName;

    @JsonProperty(Constants.AGE)
    private @Getter @Setter Integer age;

    @JsonProperty(Constants.CITY)
    private @Getter @Setter Cities city;

    @JsonProperty(Constants.NICE_SCORE)
    private @Getter @Setter Double niceScore;

    @JsonProperty(Constants.GIFTS_PREFERENCES)
    private @Getter @Setter List<Category> giftsPreferences;

    public ChildInput() { }
}
