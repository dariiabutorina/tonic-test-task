package com.dev.integration.exception;

public class UnexpectedHttpStatusException extends RuntimeException {
    public UnexpectedHttpStatusException(String message) {
        super(message);
    }
}
