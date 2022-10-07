package com.example.desafio_spring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseRequest {
    private List<ProductRequest> productRequestList;
    private Long customerId;
}
