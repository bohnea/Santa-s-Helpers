package update.assignmentstrategy;

import child.Child;
import database.managers.search.SearchManager;
import database.managers.sort.CityComparators;
import database.managers.sort.SortManager;
import enums.Cities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CityScoreAssignmentStrategy implements AssignmentStrategy {
    @Override
    public final List<Child> getChildOrder() {
        // Sort all cities by their average scores
        List<Cities> cities = SortManager.sortByCriteria(
                Arrays.stream(Cities.values()).toList(),
                new SortManager.SortCriteria<>(
                        CityComparators.AVERAGE_SCORE_COMPARATOR.reversed()
                )
        );

        // Create a list of returned children
        List<Child> children = new ArrayList<>();

        // Go through each city and add the children to the list by ID
        for (Cities city: cities) {
            children.addAll(SearchManager.getChildrenByCity(city));
        }

        // Return the children
        return children;
    }
}
