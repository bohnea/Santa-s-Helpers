package child.scorestrategy;

import common.Utils;

import java.util.List;
import java.util.stream.IntStream;

public class TeenScoreStrategy implements ScoreStrategy {
    /**
     * Calculates the average score for teens. Returns the weighted mean of the given scores.
     * @param scores the list of scores
     * @return the average score
     */
    @Override
    public final Double getAverageScore(final List<Double> scores) {
        // Get the weighted sum of the scores
        double sum = 0.0d;
        for (int i: IntStream.range(0, scores.size()).boxed().toList()) {
            sum += scores.get(i) * (i + 1);
        }

        // Return the average score
        return sum / Utils.getSumOfFirstNIntegers(scores.size());
    }
}
