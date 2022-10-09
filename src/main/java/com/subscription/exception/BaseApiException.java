package com.subscription.exception;

import org.springframework.http.HttpStatus;

public class BaseApiException extends Throwable{

    HttpStatus statusCode;
    String detailMessage;

    public BaseApiException(String message) {
        super(message);
        this.statusCode = HttpStatus.UNPROCESSABLE_ENTITY;
    }

    public BaseApiException(String message, String detailMessage, ErrorType errorType) {
        super(message);
        this.statusCode = errorType.getHttpStatus();
        this.detailMessage = detailMessage;
    }

    public BaseApiException(String message, ErrorType errorType) {
        super(message);
        this.statusCode = errorType.getHttpStatus();
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public String getDetailMessage() {
        return detailMessage;
    }
}
