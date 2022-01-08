package update.assignmentstrategy;

import child.Child;

import java.util.List;

public interface AssignmentStrategy {
    /**
     * Returns all children from the database in a specific order.
     * @return a sorted list of children
     */
    List<Child> getChildOrder();
}
