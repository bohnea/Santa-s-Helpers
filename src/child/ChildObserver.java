package child;

public interface ChildObserver {
    /**
     * Method used in the Observer pattern, called when the Observable object notifies
     * all of its observers.
     */
    void update();
}
