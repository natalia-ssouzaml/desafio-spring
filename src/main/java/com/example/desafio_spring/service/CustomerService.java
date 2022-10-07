package com.example.desafio_spring.service;

import java.util.List;

import com.example.desafio_spring.dto.CustomerResponse;
import com.example.desafio_spring.model.Customer;

public interface CustomerService {

    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();

    Customer createCustomer(Customer customer);

    List<Customer> filterByState(String state);
}
