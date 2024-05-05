package com.techelevator.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.FileSystems;
import java.time.LocalDateTime;

public class SalesReportWriter {

    private final static String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();
    private final static String CSV_EXTENSION = ".csv";
    private final static String DOT_DELIMITER = "\\.";

    public void writeToFile(String content, String dirPath) {
        String currentDateTime = LocalDateTime.now().toString();
        String currentDateTimeSansMilliSeconds = currentDateTime.split(DOT_DELIMITER)[0];
        String filePath = dirPath + FILE_SEPARATOR + currentDateTimeSansMilliSeconds + CSV_EXTENSION;

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(content);
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
