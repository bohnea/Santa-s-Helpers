package child.scorestrategy;

import common.Constants;

public final class ScoreStrategyFactory {
    /**
     * Hidden constructor.
     */
    private ScoreStrategyFactory() { }

    /**
     * Determines what ScoreStrategy to create based on the given age.
     * @param age determines what strategy to create
     * @return the appropriate strategy
     */
    public static ScoreStrategy createScoreStrategy(final int age) {
        if (age < Constants.BABY_MAX_AGE) {
            // Create Baby strategy
            return new BabyScoreStrategy();
        } else if (age < Constants.KID_MAX_AGE) {
            // Create Kid strategy
            return new KidScoreStrategy();
        } else if (age <= Constants.TEEN_MAX_AGE) {
            // Create Teen strategy
            return new TeenScoreStrategy();
        } else {
            // Don't create anything
            return null;
        }
    }
}
