package com.subscription.exception;

import org.springframework.http.HttpStatus;

public enum ErrorType {
    ALREADY_EXIST(HttpStatus.CONFLICT),
    NOT_FOUND(HttpStatus.NOT_FOUND),
    OPERATION_FAILURE(HttpStatus.UNPROCESSABLE_ENTITY);

    private HttpStatus httpStatus;
    ErrorType(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
