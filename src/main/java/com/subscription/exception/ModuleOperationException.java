package com.subscription.exception;

public class ModuleOperationException extends BaseApiException {
    public ModuleOperationException(String message, String detailMessage, ErrorType errorType) {
        super(message, detailMessage, errorType);
    }

    public ModuleOperationException(String message, ErrorType errorType) {
        super(message, errorType);
    }
}
