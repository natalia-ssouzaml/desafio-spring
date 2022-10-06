package com.example.desafio_spring.exception;

public class CreationFailureException extends RuntimeException {
    public CreationFailureException(String message) {
        super(message);
    }
}
