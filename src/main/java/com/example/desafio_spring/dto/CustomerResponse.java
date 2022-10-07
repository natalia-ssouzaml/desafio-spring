package com.example.desafio_spring.dto;

import com.example.desafio_spring.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public static CustomerResponse convertToResponse(Customer customer) {
        return new CustomerResponse(customer.getCustomerId(), customer.getName(), customer.getCity(),
                customer.getState());
    }

    public static List<CustomerResponse> convertListToResponse(List<Customer> customerList) {

        return customerList.stream()
                .map(CustomerResponse::convertToResponse)
                .collect(Collectors.toList());

    }
}
