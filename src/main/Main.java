package main;

import checker.Checker;
import child.Child;
import common.Constants;
import database.Database;
import gift.Gift;
import io.input.Input;
import io.input.InputReader;
import io.output.Output;
import io.output.OutputWriter;
import update.AnnualUpdate;

import java.io.File;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Class used to run the code
 */
public final class Main {
    /**
     * Hidden constructor.
     */
    private Main() { }

    /**
     * Creates a File for the given test index.
     * @param testIndex the test index
     * @return a new file used as input
     */
    private static File generateInputFileFromTestIndex(final int testIndex) {
        return new File(Constants.INPUT_PATH + testIndex + Constants.FILE_EXTENSION);
    }

    /**
     * Creates a File for the given test index.
     * @param testIndex the test index
     * @return a new file used as output
     */
    private static File generateOutputFileFromTestIndex(final int testIndex) {
        return new File(Constants.OUTPUT_PATH + testIndex + Constants.FILE_EXTENSION);
    }

    /**
     * Parses the input from the given input file index, stores it in the database and creates
     * a new SantaTracker to take care of the rest.
     * @param testIndex the current test index
     * @return a new SantaTracker to take care of the yearly simulation
     */
    private static SantaTracker parseAndStoreInput(final int testIndex) {
        // Parse the current file's data
        Input input = InputReader.readInput(generateInputFileFromTestIndex(testIndex));

        // If the input could not be read, return false
        if (input == null) {
             return null;
        }

        // Store the rest of the information in the database
        List<Child> children = input.getInitialDataInput()
                .getChildInput().stream()
                .map(Child.Builder::new)
                .map(Child.Builder::build)
                .toList();

        List<Gift> gifts = input.getInitialDataInput()
                .getGiftInput().stream()
                .map(Gift::new)
                .toList();

        List<AnnualUpdate> annualUpdates = input.getAnnualUpdates().stream()
                .map(AnnualUpdate::new)
                .toList();

        // Store them in the database
        Database.getInstance().add(children);
        Database.getInstance().add(gifts);
        Database.getInstance().add(annualUpdates);

        // Return an initialized SantaTracker
        return new SantaTracker(input.getNumberOfYears(), input.getSantaBudget());
    }

    /**
     * This method is used to call the checker which calculates the score. It's also used
     * to read the input and write the output for each test.
     * @param args the arguments used to call the main method
     */
    public static void main(final String[] args) {
        // Create the output folder
        File outputFile = new File("output");
        outputFile.mkdir();

        // Go through each test
        for (int test: IntStream.range(1, Constants.TESTS_NUMBER + 1).boxed().toList()) {
            // Parse input, store it in database and create a new SantaTracker
            SantaTracker santaTracker = parseAndStoreInput(test);

            // If the input could not be read, skip to the next test
            if (santaTracker == null) {
                Database.getInstance().clear();
                continue;
            }

            // Start the yearly simulation and get the results
            Output output = santaTracker.startSimulation();

            // Write the results to the corresponding output file
            OutputWriter.writeOutput(generateOutputFileFromTestIndex(test), output);

            // Clear the database and go to the next update
            Database.getInstance().clear();
        }

        // Pass all the tests :)
        Checker.calculateScore();
    }
}
