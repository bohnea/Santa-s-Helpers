package child;

import child.scorestrategy.ScoreStrategy;
import child.scorestrategy.ScoreStrategyFactory;
import database.DatabaseTrackable;
import enums.Category;
import enums.Cities;
import enums.ElvesType;

import java.util.ArrayList;
import java.util.List;

public class Child implements DatabaseTrackable {
    private final int id;
    private String lastName;
    private String firstName;
    private int age;
    private Cities city;
    private List<Double> niceScores;
    private List<Category> giftsPreference;
    private ScoreStrategy scoreStrategy;
    private Double niceScoreBonus;
    private ElvesType elf;

    public Child(final int id, final String lastName, final String firstName, final int age,
                 final Cities city, final List<Double> niceScores,
                 final List<Category> giftsPreference, final ElvesType elf) {
        // Set the default values
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScores = new ArrayList<>(niceScores);
        this.giftsPreference = new ArrayList<>(giftsPreference);
        this.elf = elf;

        // Set the default niceScoreBonus value to 0
        niceScoreBonus = 0.0d;

        // Update current score strategy
        updateScoreStrategy();
    }

    public final int getId() {
        return id;
    }

    public final String getLastName() {
        return lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final int getAge() {
        return age;
    }

    public final Cities getCity() {
        return city;
    }

    public final List<Double> getNiceScores() {
        return niceScores;
    }

    public final List<Category> getGiftsPreference() {
        return giftsPreference;
    }

    /**
     * NiceScoreBonus setter following the Builder pattern.
     * @param niceScoreBonus the new niceScoreBonus
     * @return the same child
     */
    public final Child setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
        return this;
    }

    /**
     * Recalculates the child's score strategy, with the help of the ScoreStrategyFactory.
     */
    private void updateScoreStrategy() {
        scoreStrategy = ScoreStrategyFactory.createScoreStrategy(age);
    }

    /**
     * Adds '1' to the child's age.
     */
    private void incrementAge() {
        ++age;
    }

    /**
     * Adds a new nice score to the list of nice scores.
     * @param niceScore the nice score to add
     */
    protected final void addNiceScore(final Double niceScore) {
        // If the given score is null, return
        if (niceScore == null) {
            return;
        }

        // Otherwise, add the score to the list
        niceScores.add(niceScore);
    }

    /**
     * Adds new preferences to the list of preferences. The new preferences are added
     * to the beginning of the list, in the order they are given, and all duplicates
     * are removed, always leaving the leftmost clone alive.
     * @param newGiftPreferences a list of new gift preferences
     */
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

    /**
     * Used in the Observer pattern, is called at the beginning of each yearly round.
     */
    public final void update() {
        // Add a year to the age
        incrementAge();

        // Recalculate the score strategy
        updateScoreStrategy();
    }

    /**
     * Gets the child's average score based on the score strategy.
     * @return the child's average score
     */
    public final Double getAverageScore() {
        return scoreStrategy.getAverageScore(niceScores) + niceScoreBonus;
    }

    /**
     * Gets the primary key, for use with the database.
     * @return the primary key
     */
    @Override
    public final String getKey() {
        return String.valueOf(id);
    }
}
