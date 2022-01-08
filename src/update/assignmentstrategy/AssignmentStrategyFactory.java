package update.assignmentstrategy;

import enums.CityStrategyEnum;

public final class AssignmentStrategyFactory {
    /**
     * Hidden constructor.
     */
    private AssignmentStrategyFactory() { }

    /**
     * Determines what AssignmentStrategy to create based on the given type.
     * @param type determines what strategy to create
     * @return the appropriate strategy
     */
    public static AssignmentStrategy createGiftStrategy(final CityStrategyEnum type) {
        return switch (type) {
            case ID -> new IDAssignmentStrategy();
            case NICE_SCORE -> new ChildScoreAssignmentStrategy();
            case NICE_SCORE_CITY -> new CityScoreAssignmentStrategy();
        };
    }
}
