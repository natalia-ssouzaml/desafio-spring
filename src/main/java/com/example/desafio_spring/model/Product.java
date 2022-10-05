package com.example.desafio_spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String category;
    private String brand;
    private BigDecimal price;
    private Integer quantity;
    private Boolean freeShipping;
    private String prestige;
}
