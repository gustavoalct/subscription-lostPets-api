package com.subscription.exception;

public enum ErrorMessage {
    ALREADY_EXIST("Customer already exist"),
    CUSTOMER_NOT_FOUND("Customer not found");

    private final String message;

    ErrorMessage(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}