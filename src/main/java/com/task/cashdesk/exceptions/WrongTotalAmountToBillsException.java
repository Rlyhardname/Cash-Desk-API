package com.task.cashdesk.exceptions;

public class WrongTotalAmountToBillsException extends RuntimeException {
    public WrongTotalAmountToBillsException(String message) {
        super(message);
    }
}
