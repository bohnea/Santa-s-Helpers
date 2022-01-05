package main;

import checker.Checker;
import child.Child;
import common.Constants;
import database.Database;
import child.ChildFactory;
import io.Input;
import io.InputReader;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        // constructor for checkstyle
    }

    private static boolean parseInputAndStore(int testIndex) {
        // Parse the current file's data
        Input input = InputReader.readInput(testIndex);

        // If the input could not be read, return false
        if (input == null) {
             return false;
        }

        // Initialize Santa Tracker
        SantaTracker.getInstance().setNumberOfYears(input.getNumberOfYears());
        SantaTracker.getInstance().setSantaBudget(input.getSantaBudget());

        // Store the rest of the information in the database
        List<Child> children = input.getInitialDataInput()
                .getChildInput().stream()
                .map(ChildFactory::createChild)
                .toList();


        // The input has been read and stored
        return true;
    }

    private static void getUpdatesAndExecute() {

    }

    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) {
        // Test the first argument and check whether to run all tests or not
        boolean runCustomTests = args.length >= 1 && args[0].compareTo(Constants.ALL_TESTS) == 0;

        // Create custom test sets
        List<Integer> allTests = IntStream.range(1, Constants.TESTS_NUMBER + 1).boxed().toList();
        List<Integer> customTests = List.of(1, 2, 3);

        // Go through each test
        for (int test: runCustomTests ? allTests : customTests) {
            // Parse input and store in database
            boolean parsingWasSuccessful = parseInputAndStore(test);

            // If the input could not be read, skip to the next test
            if (!parsingWasSuccessful) {
                Database.getInstance().clear();
                continue;
            }

            // Go through the annual updates and apply them
            getUpdatesAndExecute();

            // Clear the database and go to the next update
            Database.getInstance().clear();
        }

        // Pass all the tests :)
        Checker.calculateScore();
    }
}
