package child.scorestrategy;

import java.util.List;

public class KidScoreStrategy implements ScoreStrategy {
    @Override
    public Double getAverageScore(List<Double> scores) {
        // Get the sum of the scores
        Double sum = 0.0d;
        for (Double score: scores) {
            sum += score;
        }

        // Return the average score
        return sum / scores.size();
    }
}
