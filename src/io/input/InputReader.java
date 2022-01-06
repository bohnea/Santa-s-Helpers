package io.input;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;

import java.io.File;
import java.io.IOException;

public final class InputReader {
    /**
     * Hidden constructor.
     */
    private InputReader() { }

    /**
     * Parses the input JSON file based on the given test index, creating a new Input object.
     * @param testIndex the input test index
     * @return an Input object containing all parsed information, or null if either the file
     *         does not exist, or the input reading failed
     */
    public static Input readInput(final int testIndex) {
        // Create an object mapper
        ObjectMapper objMapper = new ObjectMapper();

        try {
            // Try to open the input file and read the input
            return objMapper.readValue(new File(Constants.INPUT_PATH
                    + testIndex + Constants.FILE_EXTENSION), Input.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
