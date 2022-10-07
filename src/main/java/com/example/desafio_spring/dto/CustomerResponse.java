package com.example.desafio_spring.dto;

import com.example.desafio_spring.model.Customer;
import com.example.desafio_spring.model.Purchase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private Long customerId;
    private String name;
    private String city;
    private String state;
    private List<Purchase> purchaseList;

    public static CustomerResponse convertToResponse(Customer customer) {
        return new CustomerResponse(customer.getCustomerId(), customer.getName(), customer.getCity(),
                customer.getState(), customer.getPurchaseList());
    }

    public static List<CustomerResponse> convertListToResponse(List<Customer> customerList) {

        return customerList.stream()
                .map(CustomerResponse::convertToResponse)
                .collect(Collectors.toList());

    }
}
