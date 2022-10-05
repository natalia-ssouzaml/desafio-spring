package com.example.desafio_spring.exception;

public class ReadingFailException extends RuntimeException{
    public ReadingFailException(String message) {
        super(message);
    }
}
