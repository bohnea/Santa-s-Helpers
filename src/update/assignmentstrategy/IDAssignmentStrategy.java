package update.assignmentstrategy;

import child.Child;
import database.managers.search.SearchManager;
import database.managers.sort.ChildComparators;
import database.managers.sort.SortManager;

import java.util.List;

public class IDAssignmentStrategy implements AssignmentStrategy {
    /**
     * Gets all children from the database and sorts them in increasing order by ID.
     * @return the list of ordered children
     */
    @Override
    public final List<Child> getChildOrder() {
        return SortManager.sortByCriteria(
                SearchManager.getChildrenFromDatabase(),
                new SortManager.SortCriteria<>(
                        ChildComparators.ID_COMPARATOR
                )
        );
    }
}
