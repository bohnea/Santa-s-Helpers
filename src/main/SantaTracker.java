package main;

public class SantaTracker {
    /**
     * The Singleton instance.
     */
    private static SantaTracker instance = null;

    private SantaTracker() { }

    /**
     * Gets the instance of the SantaTracker Singleton, if it exists, or creates a new one.
     * @return the Singleton instance
     */
    public static SantaTracker getInstance() {
        if (instance == null) {
            instance = new SantaTracker();
        }

        return instance;
    }

    private int numberOfYears;
    private Double santaBudget;

    protected void setNumberOfYears(final int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    protected void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }
}
