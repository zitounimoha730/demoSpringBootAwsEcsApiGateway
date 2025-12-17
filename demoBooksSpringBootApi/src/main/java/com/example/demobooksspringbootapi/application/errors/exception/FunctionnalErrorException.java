package com.example.demobooksspringbootapi.application.errors.exception;

public class FunctionnalErrorException extends RuntimeException {

    public FunctionnalErrorException(String message) {
        super(message);
    }
}
