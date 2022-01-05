package main;

import checker.Checker;
import child.Child;
import common.Constants;
import database.Database;
import child.ChildFactory;
import gift.Gift;
import gift.GiftFactory;
import io.input.Input;
import io.input.InputReader;
import io.output.Output;
import io.output.OutputWriter;
import update.AnnualUpdate;
import update.UpdateFactory;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Class used to run the code
 */
public final class Main {
    private Main() { }

    private static boolean parseAndStoreInput(int testIndex) {
        // Parse the current file's data
        Input input = InputReader.readInput(testIndex);

        // If the input could not be read, return false
        if (input == null) {
             return false;
        }

        // Store the rest of the information in the database
        List<Child> children = input.getInitialDataInput()
                .getChildInput().stream()
                .map(ChildFactory::createChild)
                .toList();

        List<Gift> gifts = input.getInitialDataInput()
                .getGiftInput().stream()
                .map(GiftFactory::createGift)
                .toList();

        List<AnnualUpdate> annualUpdates = input.getAnnualUpdates().stream()
                .map(UpdateFactory.AnnualUpdateFactory::createAnnualUpdate).toList();

        // Store them in the database
        Database.getInstance().add(children);
        Database.getInstance().add(gifts);
        Database.getInstance().add(annualUpdates);

        // Initialize Santa Tracker
        SantaTracker.getInstance().initialize(
                input.getNumberOfYears(),
                input.getSantaBudget()
        );

        // The input has been read and stored
        return true;
    }

    /**
     * This method is used to call the checker which calculates the score
     * @param args the arguments used to call the main method
     */
    public static void main(final String[] args) {
        // Test the first argument and check whether to run all tests or not
        boolean runCustomTests = args.length >= 1 && args[0].compareTo(Constants.ALL_TESTS) == 0;

        // Create custom test sets
        List<Integer> allTests = IntStream.range(1, Constants.TESTS_NUMBER + 1).boxed().toList();
        List<Integer> customTests = List.of(14);

        // Go through each test
        for (int test: runCustomTests ? allTests : customTests) {
            // Parse input and store in database
            boolean parsingWasSuccessful = parseAndStoreInput(test);

            // If the input could not be read, skip to the next test
            if (!parsingWasSuccessful) {
                Database.getInstance().clear();
                continue;
            }

            // Start the yearly simulation and get the results
            Output output = SantaTracker.getInstance().startSimulation();

            // Write the results to the corresponding output file
            OutputWriter.writeOutput(test, output);

            // Clear the database and go to the next update
            Database.getInstance().clear();
        }

        // Pass all the tests :)
        Checker.calculateScore();
    }
}
