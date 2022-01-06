package child.scorestrategy;

import java.util.List;

public class KidScoreStrategy implements ScoreStrategy {
    /**
     * Calculates the average score for kids. Returns the mean of the given scores.
     * @param scores the list of scores
     * @return the average score
     */
    @Override
    public final Double getAverageScore(final List<Double> scores) {
        // Get the sum of the scores
        Double sum = 0.0d;
        for (Double score: scores) {
            sum += score;
        }

        // Return the average score
        return sum / scores.size();
    }
}
