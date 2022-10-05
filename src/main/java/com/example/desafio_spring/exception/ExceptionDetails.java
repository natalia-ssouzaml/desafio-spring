package com.example.desafio_spring.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder //Habilita o padrao builder para gerar o objeto.
public class ExceptionDetails {
    private String title;
    private int status;
    private String message;
    private LocalDateTime timeStamp;


}