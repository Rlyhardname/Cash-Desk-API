package com.task.cashdesk.exceptions;

public class LackOfBillsException extends RuntimeException{
    public LackOfBillsException(String message) {
        super(message);
    }
}
