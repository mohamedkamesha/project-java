package com.example.cv_hk_project.exception;

public class HandlerError extends RuntimeException {

    public HandlerError() {

    }

    public HandlerError(String message) {
        super(message);
    }

    public HandlerError(String message, Throwable cause) {
        super(message, cause);
    }

    public HandlerError(Throwable cause) {
        super(cause);
    }

    public HandlerError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
