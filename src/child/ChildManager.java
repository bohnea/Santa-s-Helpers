package child;

import database.Database;
import update.ChildUpdate;

public class ChildManager {
    public void applyChildUpdate(final ChildUpdate childUpdate) {
        // Retrieve the child with the given ID from the database
        Child childToUpdate = (Child) Database.getInstance()
                .retrieveEntity(Child.class, String.valueOf(childUpdate.getId()));

        // If the child was not found, return
        if (childToUpdate == null) {
            return;
        }

        // Add the new nice score to the child, if the score isn't null
        childToUpdate.addNiceScore(childUpdate.getNiceScore());

        // Add the new gift preferences to the child's preferences
        childToUpdate.addPreferences(childUpdate.getGiftsPreferences());
    }
}
