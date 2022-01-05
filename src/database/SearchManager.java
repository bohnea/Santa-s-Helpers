package database;

import child.Child;
import enums.Category;
import gift.Gift;
import update.AnnualUpdate;

import java.util.Comparator;
import java.util.List;

public final class SearchManager {
    public static List<Child> getChildrenFromDatabase() {
        // Get the children from the database
        return Database.getInstance()
                .retrieveClassEntities(Child.class)
                .values().stream()
                // Cast them to the appropriate type
                .map(databaseTrackable -> (Child) databaseTrackable)
                .toList();
    }

    public static List<Gift> getGiftsFromDatabase() {
        // Get the gifts from the database
        return Database.getInstance()
                .retrieveClassEntities(Gift.class)
                .values().stream()
                // Cast them to the appropriate type
                .map(databaseTrackable -> (Gift) databaseTrackable)
                .toList();
    }

    public static Gift getCheapestGiftOfCategory(final Category category) {
        // Get all the gifts from the database
        return getGiftsFromDatabase().stream()
                // Get the gifts of the given category
                .filter(gift -> gift.getCategory() == category)
                // Get the cheapest gift
                .min(Comparator.comparingDouble(Gift::getPrice))
                // Otherwise, return null
                .orElse(null);
    }

    public static List<AnnualUpdate> getAnnualUpdatesFromDatabase() {
        // Get the annual updates from the database
        return Database.getInstance()
                .retrieveClassEntities(AnnualUpdate.class)
                .values().stream()
                // Cast them to the appropriate type
                .map(databaseTrackable -> (AnnualUpdate) databaseTrackable)
                .toList();
    }
}
