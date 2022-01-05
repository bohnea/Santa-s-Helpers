package io.output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import common.Constants;

import java.io.File;
import java.io.IOException;

public class OutputWriter {
    public static void writeOutput(int testIndex, Output output) {
        // Create an object writer
        ObjectWriter objWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();

        try {
            // Try to open the output file and write the output
            objWriter.writeValue(new File(Constants.OUTPUT_PATH +
                    testIndex + Constants.FILE_EXTENSION), output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
