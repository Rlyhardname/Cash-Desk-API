package com.task.cashdesk.exceptions;

public class UnsupportedCurrencyException extends RuntimeException{
    public UnsupportedCurrencyException(String message) {
        super(message);
    }
}
