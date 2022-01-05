package child.scorestrategy;

import java.util.List;

public class BabyScoreStrategy implements ScoreStrategy {
    @Override
    public Double getAverageScore(List<Double> scores) {
        return 10.0d;
    }
}
