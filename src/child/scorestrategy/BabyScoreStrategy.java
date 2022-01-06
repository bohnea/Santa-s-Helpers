package child.scorestrategy;

import java.util.List;

public class BabyScoreStrategy implements ScoreStrategy {
    /* The constant average score */
    private static final double DEFAULT_AVERAGE_SCORE = 10.0d;

    /**
     * Calculates the average score for babies. Returns a constant value.
     * @param scores the list of scores
     * @return the average score
     */
    @Override
    public final Double getAverageScore(final List<Double> scores) {
        return DEFAULT_AVERAGE_SCORE;
    }
}
