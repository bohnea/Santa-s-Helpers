package io.output.child;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import enums.Category;
import enums.Cities;
import io.output.gift.GiftOutput;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ChildOutput {
    @JsonProperty(Constants.ID)
    private @Getter @Setter Integer id;

    @JsonProperty(Constants.LAST_NAME)
    private @Getter @Setter String lastName;

    @JsonProperty(Constants.FIRST_NAME)
    private @Getter @Setter String firstName;

    @JsonProperty(Constants.CITY)
    private @Getter @Setter Cities city;

    @JsonProperty(Constants.AGE)
    private @Getter @Setter Integer age;

    @JsonProperty(Constants.GIFTS_PREFERENCES)
    private @Getter @Setter List<Category> giftsPreferences;

    @JsonProperty(Constants.AVERAGE_SCORE)
    private @Getter @Setter Double averageScore;

    @JsonProperty(Constants.NICE_SCORE_HISTORY)
    private @Getter @Setter List<Double> niceScoreHistory;

    @JsonProperty(Constants.ASSIGNED_BUDGET)
    private @Getter @Setter Double assignedBudget;

    @JsonProperty(Constants.RECEIVED_GIFTS)
    private @Getter @Setter List<GiftOutput> receivedGifts;

    public ChildOutput() { }

    public ChildOutput(final Integer id, final String lastName, final String firstName,
                       final Cities city, final Integer age, final List<Category> giftsPreferences,
                       final Double averageScore, final List<Double> niceScoreHistory,
                       final Double assignedBudget, final List<GiftOutput> receivedGifts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = new ArrayList<>(giftsPreferences);
        this.averageScore = averageScore;
        this.niceScoreHistory = new ArrayList<>(niceScoreHistory);
        this.assignedBudget = assignedBudget;
        this.receivedGifts = new ArrayList<>(receivedGifts);
    }
}
