package com.example.demobooksspringbootapi.domain.commons.errors;

public class InfrastructureException extends RuntimeException {

    public InfrastructureException(String message) {
        super(message);
    }

    public InfrastructureException(Throwable throwable) {
        super(throwable);
    }
}
