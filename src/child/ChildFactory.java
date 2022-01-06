package child;

import io.input.child.ChildInput;

import java.util.List;

public final class ChildFactory {
    /**
     * Hidden constructor.
     */
    private ChildFactory() { }

    /**
     * Creates a new Child based on the given ChildInput.
     * @param childInput the child input to turn into a child
     * @return the created child
     */
    public static Child createChild(final ChildInput childInput) {
        return new Child(
                childInput.getId(),
                childInput.getLastName(),
                childInput.getFirstName(),
                childInput.getAge(),
                childInput.getCity(),
                List.of(childInput.getNiceScore()),
                childInput.getGiftsPreferences(),
                childInput.getNiceScoreBonus(),
                childInput.getElf()
        );
    }
}
