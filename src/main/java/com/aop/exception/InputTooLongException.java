package com.aop.exception;

public class InputTooLongException extends RuntimeException {
    public InputTooLongException(String message) {
        super(message);
    }
}
