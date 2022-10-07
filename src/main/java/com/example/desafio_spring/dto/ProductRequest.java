package com.example.desafio_spring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor

public class ProductRequest {
    @NotNull
    private Long productId;
    @NotNull
    private int quantity;
}
