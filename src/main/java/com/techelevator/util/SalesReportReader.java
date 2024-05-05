package com.techelevator.util;

import com.techelevator.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.HashMap;
import java.util.Map;

public class SalesReportReader implements DataReader<Map<String, Integer>> {

    private final String directoryPath;

    public SalesReportReader(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    @Override
    public Map<String, Integer> readData() {
        try {
            Path dirPath = Paths.get(directoryPath);
            if (!Files.exists(dirPath) || !Files.isDirectory(dirPath)) {
                return new HashMap<>();
            }

            Path latestFile = findLatestFile(dirPath);

            if (latestFile == null) {
                return new HashMap<>();
            }

            return readSalesDataFromFile(latestFile);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read sales data. ", e);
        }

    }

    private Path findLatestFile(Path dirPath) throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dirPath)) {
            Path latestFile = null;
            FileTime latestTime = null;

            for (Path file : stream) {
                FileTime fileTime = Files.getLastModifiedTime(file);

                if (latestFile == null || fileTime.compareTo(latestTime) > 0) {
                    latestFile = file;
                    latestTime = fileTime;
                }
            }

            return latestFile;
        }
    }

    private Map<String, Integer> readSalesDataFromFile(Path file) throws IOException {
        Map<String, Integer> salesData = new HashMap<>();

        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {
            String lineFromFile;

            while (bufferedReader.ready()) {
                lineFromFile = bufferedReader.readLine();
                String[] lineDataArray = lineFromFile.split("\\|");

                if (lineDataArray.length == 2) {
                    salesData.put(lineDataArray[0], Integer.parseInt(lineDataArray[1]));
                }
            }

            return salesData;
        }
    }
}
