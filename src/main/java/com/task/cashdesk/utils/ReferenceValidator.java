package com.task.cashdesk.utils;

import com.task.cashdesk.exceptions.DuplicateOperationException;

import java.util.List;

public class ReferenceValidator {
    public static void checkForRecordDuplication(List<String> lines, String reference) {
        System.out.println("lines size:" + lines.size() + "line content: " + lines.get(0));
        System.out.println("reference to compare with:" + reference);
        for (String line : lines) {
            if (line.contains(reference)) {
                throw new DuplicateOperationException();
            }
        }
    }
}
