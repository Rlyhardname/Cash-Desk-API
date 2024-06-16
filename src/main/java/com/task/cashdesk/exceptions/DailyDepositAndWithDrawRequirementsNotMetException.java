package com.task.cashdesk.exceptions;

public class DailyDepositAndWithDrawRequirementsNotMetException extends RuntimeException {
    public DailyDepositAndWithDrawRequirementsNotMetException(String message) {
        super(message);
    }
}
