package com.example.desafio_spring.exception;

public class AlreadyExistentException extends RuntimeException {

    public AlreadyExistentException(String message) {
        super(message);
    }
}
