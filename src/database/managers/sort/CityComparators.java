package database.managers.sort;

import enums.Cities;

import java.util.Comparator;

public final class CityComparators {
    /**
     * Hidden constructor.
     */
    private CityComparators() { }

    // Sort ascending by average score
    public static final Comparator<Cities> AVERAGE_SCORE_COMPARATOR =
            Comparator.comparingDouble(Cities::getAverageRating);
}
