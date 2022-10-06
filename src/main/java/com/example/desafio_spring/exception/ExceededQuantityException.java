package com.example.desafio_spring.exception;

public class ExceededQuantityException extends RuntimeException {
    public ExceededQuantityException(String message) {
        super(message);
    }
}
