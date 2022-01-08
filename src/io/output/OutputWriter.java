package io.output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;

public final class OutputWriter {
    /**
     * Hidden constructor.
     */
    private OutputWriter() { }

    /**
     * Writes, in JSON format, the given Output object to the corresponding output file.
     * @param outputFile the output file
     * @param output the Output object to write to the file
     */
    public static void writeOutput(final File outputFile, final Output output) {
        try {
            // Create the output file
            outputFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create an object writer
        ObjectWriter objWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();

        try {
            // Try to open the output file and write the output
            objWriter.writeValue(outputFile, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
