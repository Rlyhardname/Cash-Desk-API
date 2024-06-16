package com.task.cashdesk.io.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

public class Reader {
    public static List<String> readTxtReturnRerordsList(String date, String operation) throws NoSuchFileException {
        String fileUrl = "src/main/resources/ignore/" + date + "_" + operation + ".txt";
        try {
            return Files.readAllLines(Path.of(fileUrl));
        } catch (IOException e) {
            throw new NoSuchFileException(fileUrl);
        }
    }

}
