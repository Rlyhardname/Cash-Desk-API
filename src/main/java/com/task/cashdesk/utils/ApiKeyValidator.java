package com.task.cashdesk.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ApiKeyValidator {
    private static String KEY_PATH = "src/main/resources/ignore/apikey.txt";

    public static boolean isValid(String apiKey) {
        return Objects.equals(apiKey, readKey());
    }

    // Implementation will change later on when we store keys in DB;
    protected static String readKey() {
        try (BufferedReader br = Files.newBufferedReader(Path.of(KEY_PATH))) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
