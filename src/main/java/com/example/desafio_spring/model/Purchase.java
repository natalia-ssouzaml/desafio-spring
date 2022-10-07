package com.example.desafio_spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    private Long purchaseId;
    private List<Product> productList;
    private BigDecimal total;
    private Long customerId;

    public static final List<Purchase> purchaseList = new ArrayList<>();
}
