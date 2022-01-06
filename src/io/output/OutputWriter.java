package io.output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import common.Constants;

import java.io.File;
import java.io.IOException;

public final class OutputWriter {
    /**
     * Hidden constructor.
     */
    private OutputWriter() { }

    /**
     * Writes, in JSON format, the given Output object to the corresponding output file.
     * @param testIndex the output test index
     * @param output the Output object to write to the file
     */
    public static void writeOutput(final int testIndex, final Output output) {
        // Create an object writer
        ObjectWriter objWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();

        try {
            // Try to open the output file and write the output
            objWriter.writeValue(new File(Constants.OUTPUT_PATH
                    + testIndex + Constants.FILE_EXTENSION), output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
