package com.task.cashdesk.io.utils;

import com.task.cashdesk.models.dto.CashDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Writer {
    public static void writeDepositToTxt(CashDTO cashDTO, String operation) {
        try {
            Files.writeString(Path.of("src/main/resources/ignore/" + cashDTO.getDate() + "_" + operation + ".txt"), cashDTO.toString() + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.out.println("hello?");
            throw new RuntimeException(e);
        }
    }

}
