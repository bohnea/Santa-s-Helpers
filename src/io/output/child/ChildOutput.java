package io.output.child;

import child.Child;
import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import enums.Category;
import enums.Cities;
import gift.Gift;
import io.output.gift.GiftOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * Class created for JSON parsing.
 */
public class ChildOutput {
    @JsonProperty(Constants.ID)
    private Integer id;

    @JsonProperty(Constants.LAST_NAME)
    private String lastName;

    @JsonProperty(Constants.FIRST_NAME)
    private String firstName;

    @JsonProperty(Constants.CITY)
    private Cities city;

    @JsonProperty(Constants.AGE)
    private Integer age;

    @JsonProperty(Constants.GIFTS_PREFERENCES)
    private List<Category> giftsPreferences;

    @JsonProperty(Constants.AVERAGE_SCORE)
    private Double averageScore;

    @JsonProperty(Constants.NICE_SCORE_HISTORY)
    private List<Double> niceScoreHistory;

    @JsonProperty(Constants.ASSIGNED_BUDGET)
    private Double assignedBudget;

    @JsonProperty(Constants.RECEIVED_GIFTS)
    private List<GiftOutput> receivedGifts;

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

    public ChildOutput(final Child child, final Double assignedBudget,
                       final List<Gift> receivedGifts) {
        this(
                child.getId(),
                child.getLastName(),
                child.getFirstName(),
                child.getCity(),
                child.getAge(),
                child.getGiftsPreference(),
                child.getAverageScore(),
                child.getNiceScores(),
                assignedBudget,
                receivedGifts.stream().map(GiftOutput::new).toList()
        );
    }

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final Cities getCity() {
        return city;
    }

    public final void setCity(final Cities city) {
        this.city = city;
    }

    public final Integer getAge() {
        return age;
    }

    public final void setAge(final Integer age) {
        this.age = age;
    }

    public final List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public final void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public final Double getAverageScore() {
        return averageScore;
    }

    public final void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public final List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public final void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public final Double getAssignedBudget() {
        return assignedBudget;
    }

    public final void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public final List<GiftOutput> getReceivedGifts() {
        return receivedGifts;
    }

    public final void setReceivedGifts(final List<GiftOutput> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }
}
