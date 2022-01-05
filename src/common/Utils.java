package common;

import enums.Category;
import enums.Cities;

public final class Utils {
    public static Cities cityStringToEnum(String cityStr) {
        // Go through each city and test the value
        for (Cities city: Cities.values()) {
            // If the city was found, return it
            if (city.getValue().compareTo(cityStr) == 0) {
                return city;
            }
        }

        // The string cannot be found in the enum
        return null;
    }

    public static Category categoryStringToEnum(String categoryStr) {
        // Go through each category and test the value
        for (Category category: Category.values()) {
            // If the category was found, return it
            if (category.getValue().compareTo(categoryStr) == 0) {
                return category;
            }
        }

        // The string cannot be found in the enum
        return null;
    }
}
