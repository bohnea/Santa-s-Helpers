package child.scorestrategy;

import common.Constants;

import java.util.List;
import java.util.stream.IntStream;

public class TeenScoreStrategy implements ScoreStrategy {
    private int getWeightSum(int n) {
        return n * (n + 1) / 2;
    }

    @Override
    public Double getAverageScore(List<Double> scores) {
        // Get the weighted sum of the scores
        double sum = 0.0d;
        for (int i: IntStream.range(0, scores.size()).boxed().toList()) {
            sum += scores.get(i) * (i + 1);
        }

        // Return the average score
        return sum / getWeightSum(scores.size());
    }
}
