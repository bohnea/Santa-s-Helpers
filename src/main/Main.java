package main;

import checker.Checker;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        // constructor for checkstyle
    }

    private static void parseInputAndStore() {

    }

    private static void getUpdatesAndExecute() {

    }

    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) {
        // Parse input and store in database
        parseInputAndStore();

        // Go through the annual updates and apply them
        getUpdatesAndExecute();

        // Pass all the tests :)
        Checker.calculateScore();
    }
}
