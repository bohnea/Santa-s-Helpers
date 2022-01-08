package main;

public interface ChildObservable {
    /**
     * Method used in the Observer pattern, used to notify all observers of an update.
     */
    void notifyObservers();
}
