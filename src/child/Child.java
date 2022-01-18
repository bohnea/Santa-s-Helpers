package child;

import child.scorestrategy.ScoreStrategy;
import child.scorestrategy.ScoreStrategyFactory;
import database.DatabaseTrackable;
import elf.Elf;
import elf.ElfFactory;
import enums.Category;
import enums.Cities;
import io.input.child.ChildInput;

import java.util.ArrayList;
import java.util.List;

public final class Child implements DatabaseTrackable, ChildObserver {
    private final int id;
    private final String lastName;
    private final String firstName;
    private int age;
    private final Cities city;
    private final List<Double> niceScores;
    private final List<Category> giftsPreference;
    private ScoreStrategy scoreStrategy;
    private final Double niceScoreBonus;
    private Elf elf;

    private Child(final Builder builder) {
        // Set the default values
        this.id = builder.id;
        this.lastName = builder.lastName;
        this.firstName = builder.firstName;
        this.age = builder.age;
        this.city = builder.city;
        this.niceScores = new ArrayList<>(builder.niceScores);
        this.giftsPreference = new ArrayList<>(builder.giftsPreference);
        this.elf = builder.elf;
        this.niceScoreBonus = builder.niceScoreBonus;

        // Remove duplicate gift preferences
        removePreferenceDuplicates();

        // Update current score strategy
        updateScoreStrategy();
    }

    public Child(final ChildInput childInput) {
        this(new Child.Builder(
                childInput.getId(),
                childInput.getLastName(),
                childInput.getFirstName(),
                childInput.getAge(),
                childInput.getCity(),
                List.of(childInput.getNiceScore()),
                childInput.getGiftsPreferences(),
                ElfFactory.createElf(childInput.getElf())
        ).setNiceScoreBonus(childInput.getNiceScoreBonus()));
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public Cities getCity() {
        return city;
    }

    public List<Double> getNiceScores() {
        return niceScores;
    }

    public List<Category> getGiftsPreference() {
        return giftsPreference;
    }

    public Elf getElf() {
        return elf;
    }

    public void setElf(final Elf elf) {
        this.elf = elf;
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
    void addNiceScore(final Double niceScore) {
        // If the given score is null, return
        if (niceScore == null) {
            return;
        }

        // Otherwise, add the score to the list
        niceScores.add(niceScore);
    }

    /**
     * Removes all duplicate gift preferences, always leaving the leftmost clone alive.
     */
    private void removePreferenceDuplicates() {
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
     * Adds new preferences to the list of preferences. The new preferences are added
     * to the beginning of the list, in the order they are given. All duplicates
     * are removed from the list.
     * @param newGiftPreferences a list of new gift preferences
     */
    void addPreferences(final List<Category> newGiftPreferences) {
        // Add all new entries to the beginning
        giftsPreference.addAll(0, newGiftPreferences);

        // Remove duplicates
        removePreferenceDuplicates();
    }

    /**
     * Used in the Observer pattern, is called at the beginning of each yearly round.
     */
    public void update() {
        // Add a year to the age
        incrementAge();

        // Recalculate the score strategy
        updateScoreStrategy();
    }

    /**
     * Gets the child's average score based on the score strategy. Value cannot go above 10.
     * @return the child's average score
     */
    public Double getAverageScore() {
        // Declare constant values
        final double oneHundred = 100.0d;
        final double maxAverageScore = 10.0d;

        // Get the average score
        Double averageScore = scoreStrategy.getAverageScore(niceScores);

        // Return the modified average score
        return Math.min(averageScore + averageScore
                * niceScoreBonus / oneHundred, maxAverageScore);
    }

    /**
     * Gets the primary key, for use with the database.
     * @return the primary key
     */
    @Override
    public String getKey() {
        return String.valueOf(id);
    }

    /**
     * Builder class for the Child.
     */
    public static class Builder {
        private final int id;
        private final String lastName;
        private final String firstName;
        private final int age;
        private final Cities city;
        private final List<Double> niceScores;
        private final List<Category> giftsPreference;
        private Double niceScoreBonus;
        private final Elf elf;

        public Builder(final int id, final String lastName, final String firstName, final int age,
                       final Cities city, final List<Double> niceScores,
                       final List<Category> giftsPreference, final Elf elf) {
            // Set the default values
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.age = age;
            this.city = city;
            this.niceScores = new ArrayList<>(niceScores);
            this.giftsPreference = new ArrayList<>(giftsPreference);
            this.elf = elf;
        }

        /**
         * NiceScoreBonus setter following the Builder pattern.
         * @param newNiceScoreBonus the new niceScoreBonus
         * @return the same child
         */
        public final Builder setNiceScoreBonus(final Double newNiceScoreBonus) {
            this.niceScoreBonus = newNiceScoreBonus;
            return this;
        }

        /**
         * Builds the Child and returns the built object.
         * @return the built child
         */
        public Child build() {
            return new Child(this);
        }
    }
}
