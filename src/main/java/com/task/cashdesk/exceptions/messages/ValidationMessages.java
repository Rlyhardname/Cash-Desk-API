package com.task.cashdesk.exceptions.messages;

public class ValidationMessages {
    public static final String UNSUPPORTED_OPERATION = "Unsupported financial operation, try again.";
    public static final String UNSUPPORTED_CURRENCY = "The cashier doesn't offer currency operations with %s currency";
    public static final String DUPLICATE_OPERATION = "Operation wish the reference of %s has already been registered in our system.";
    public static final String NOT_ENOUGH_BILLS = "We are lacking bills with the denomination of %s in our cashier. Please make a different request with other types of bills.";
}
