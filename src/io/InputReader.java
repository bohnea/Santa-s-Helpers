package io;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;

import java.io.File;
import java.io.IOException;

public class InputReader {
    public static Input readInput(int testIndex) {
        // Create an object mapper
        ObjectMapper objMapper = new ObjectMapper();

        try {
            // Try to open the input file and read the input
            return objMapper.readValue(new File(Constants.INPUT_PATH +
                    testIndex + Constants.FILE_EXTENSION), Input.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
