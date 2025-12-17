package com.example.demobooksspringbootapi.domain.commons.errors;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DomainException extends RuntimeException {

    public DomainException(String message) {
        super(message);
    }
    public DomainException(Throwable throwable) {
        super(throwable.getMessage());
    }
}
