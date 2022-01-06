package io.input.child;

import com.fasterxml.jackson.annotation.JsonProperty;
import common.Constants;
import enums.Category;
import enums.Cities;

import java.util.List;

/**
 * Class created for JSON parsing.
 */
public class ChildInput {
    @JsonProperty(Constants.ID)
    private Integer id;

    @JsonProperty(Constants.LAST_NAME)
    private String lastName;

    @JsonProperty(Constants.FIRST_NAME)
    private String firstName;

    @JsonProperty(Constants.AGE)
    private Integer age;

    @JsonProperty(Constants.CITY)
    private Cities city;

    @JsonProperty(Constants.NICE_SCORE)
    private Double niceScore;

    @JsonProperty(Constants.GIFTS_PREFERENCES)
    private List<Category> giftsPreferences;

    public ChildInput() { }

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

    public final Integer getAge() {
        return age;
    }

    public final void setAge(final Integer age) {
        this.age = age;
    }

    public final Cities getCity() {
        return city;
    }

    public final void setCity(final Cities city) {
        this.city = city;
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
