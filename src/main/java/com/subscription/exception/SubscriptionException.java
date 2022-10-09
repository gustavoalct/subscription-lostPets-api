package com.subscription.exception;

public class SubscriptionException extends BaseApiException {

    public SubscriptionException(String message, String detailMessage, ErrorType errorType) {
        super(message, detailMessage, errorType);
    }

    public SubscriptionException(String message, ErrorType errorType) {
        super(message, errorType);
    }
}
