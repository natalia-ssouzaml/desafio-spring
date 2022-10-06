package com.example.desafio_spring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ProductRequest {
    private Long productId;
    private int quantity;

}
