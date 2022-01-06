package child.scorestrategy;

import java.util.List;

public interface ScoreStrategy {
    /**
     * Calculates the average score from the given list of scores.
     * @param scores the list of scores
     * @return the average score
     */
    Double getAverageScore(List<Double> scores);
}
