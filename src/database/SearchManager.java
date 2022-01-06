package database;

import child.Child;
import enums.Category;
import gift.Gift;
import update.AnnualUpdate;

import java.util.Comparator;
import java.util.List;

public final class SearchManager {
    /**
     * Hidden constructor.
     */
    private SearchManager() { }

    /**
     * Retrieves all children from the database.
     * @return the retrieved children
     */
    public static List<Child> getChildrenFromDatabase() {
        // Get the children from the database
        return Database.getInstance()
                .retrieveClassEntities(Child.class)
                .values().stream()
                // Cast them to the appropriate type
                .map(databaseTrackable -> (Child) databaseTrackable)
                .toList();
    }

    /**
     * Retrieves all gifts from the database.
     * @return the retrieved gifts
     */
    public static List<Gift> getGiftsFromDatabase() {
        // Get the gifts from the database
        return Database.getInstance()
                .retrieveClassEntities(Gift.class)
                .values().stream()
                // Cast them to the appropriate type
                .map(databaseTrackable -> (Gift) databaseTrackable)
                .toList();
    }

    /**
     * Looks through all gifts of the given category in the database, and retrieves the one
     * with the lowest price, or null if the retrieved list is empty.
     * @param category
     * @return
     */
    public static Gift getCheapestGiftOfCategory(final Category category) {
        // Get all the gifts from the database
        return getGiftsFromDatabase().stream()
                // Get the gifts of the given category
                .filter(gift -> gift.getCategory() == category)
                // Remove the gifts with 0 quantity
                .filter(gift -> gift.getQuantity() > 0)
                // Get the cheapest gift
                .min(Comparator.comparingDouble(Gift::getPrice))
                // Otherwise, return null
                .orElse(null);
    }

    /**
     * Retrieves all annual updates from the database.
     * @return the retrieved annual updates
     */
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
