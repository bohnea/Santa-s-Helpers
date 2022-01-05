package child;

import child.scorestrategy.ScoreStrategy;
import child.scorestrategy.ScoreStrategyFactory;
import database.DatabaseTrackable;
import enums.Category;
import enums.Cities;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Child implements DatabaseTrackable {
    private final @Getter int id;
    private @Getter String lastName;
    private @Getter String firstName;
    private @Getter int age;
    private @Getter Cities city;
    private @Getter List<Double> niceScores;
    private @Getter List<Category> giftsPreference;
    private @Getter ScoreStrategy scoreStrategy;

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

    protected final void addNiceScore(final Double niceScore) {
        // If the given score is null, return
        if (niceScore == null) {
            return;
        }

        // Otherwise, add the score to the list
        niceScores.add(niceScore);
    }

    protected final void addPreferences(final List<Category> newGiftPreferences) {
        // Add all new entries to the beginning
        giftsPreference.addAll(0, newGiftPreferences);

        // Remove all duplicates by going through each gift category
        for (int i = 0; i < giftsPreference.size(); ++i) {
            // Get the current category
            Category currentCategory = giftsPreference.get(i);

            // Remove all duplicates in the sublist to the right of the current index
            for (int j = i + 1; j < giftsPreference.size(); ++j) {
                if (giftsPreference.get(j) == currentCategory) {
                    giftsPreference.remove(j);
                    --j;
                }
            }
        }
    }

    public final void update() {
        // Add a year to his age
        incrementAge();

        // Recalculate the score strategy
        updateScoreStrategy();
    }

    public final Double getAverageScore() {
        return scoreStrategy.getAverageScore(niceScores);
    }

    @Override
    public final String getKey() {
        return String.valueOf(id);
    }
}
