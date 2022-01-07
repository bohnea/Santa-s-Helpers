package database.managers.sort;

import child.Child;

import java.util.Comparator;

public final class ChildComparators {
    /**
     * Hidden constructor.
     */
    private ChildComparators() { }

    // Sort ascending by ID
    public static final Comparator<Child> ID_COMPARATOR =
            Comparator.comparingInt(Child::getId);

    // Sort ascending by average score
    public static final Comparator<Child> AVERAGE_SCORE_COMPARATOR =
            Comparator.comparingDouble(Child::getAverageScore);
}
