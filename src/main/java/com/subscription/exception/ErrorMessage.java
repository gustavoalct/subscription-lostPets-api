package com.subscription.exception;

public enum ErrorMessage {
    ALREADY_EXIST("Customer already exist"),
    CUSTOMER_NOT_FOUND("Customer not found"),
    CUSTOMER_ADDRESS_NOT_FOUND("Customer Address not found"),
    CUSTOMER_ADDRESS_MAX_SIZE("user with full address");

    private final String message;

    ErrorMessage(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}