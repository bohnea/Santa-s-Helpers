package child.scorestrategy;

public class ScoreStrategyFactory {
    public static ScoreStrategy createScoreStrategy(int age) {
        if (age < 5) {
            // Create Baby strategy
            return new BabyScoreStrategy();
        } else if (age < 12) {
            // Create Kid strategy
            return new KidScoreStrategy();
        } else if (age <= 18) {
            // Create Teen strategy
            return new TeenScoreStrategy();
        } else {
            // Don't create anything
            return null;
        }
    }
}
