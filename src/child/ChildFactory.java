package child;

import io.input.child.ChildInput;

import java.util.List;

public class ChildFactory {
    public static Child createChild(ChildInput childInput) {
        return new Child(
                childInput.getId(),
                childInput.getLastName(),
                childInput.getFirstName(),
                childInput.getAge(),
                childInput.getCity(),
                List.of(childInput.getNiceScore()),
                childInput.getGiftsPreferences()
        );
    }
}
