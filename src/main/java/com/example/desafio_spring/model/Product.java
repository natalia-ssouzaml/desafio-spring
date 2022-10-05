package com.example.desafio_spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @NotNull
    private Long productId;
    @NotNull
    private String name;
    @NotNull
    private String category;
    @NotNull
    private String brand;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer quantity;
    @NotNull
    private Boolean freeShipping;
    @NotNull
    private String prestige;
}
