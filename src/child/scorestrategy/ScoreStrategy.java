package child.scorestrategy;

import java.util.List;

public interface ScoreStrategy {
    Double getAverageScore(List<Double> scores);
}
