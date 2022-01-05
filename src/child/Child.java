package child;

import child.scorestrategy.ScoreStrategy;
import child.scorestrategy.ScoreStrategyFactory;
import database.DatabaseTrackable;
import enums.Category;
import enums.Cities;

import java.util.ArrayList;
import java.util.List;

public class Child implements DatabaseTrackable {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private Cities city;
    private ArrayList<Double> niceScores;
    private ArrayList<Category> giftsPreference;
    private ScoreStrategy scoreStrategy;

    public Child(final int id, final String lastName, final String firstName, final int age,
                 final Cities city, final List<Double> niceScores,
                 final List<Category> giftsPreference) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScores = new ArrayList<>(niceScores);
        this.giftsPreference = new ArrayList<>(giftsPreference);

        // Update current score strategy
        updateScoreStrategy();
    }

    private void updateScoreStrategy() {
        scoreStrategy = ScoreStrategyFactory.createScoreStrategy(age);
    }

    private void incrementAge() {
        ++age;
    }

    @Override
    public final String getKey() {
        return String.valueOf(id);
    }
}
