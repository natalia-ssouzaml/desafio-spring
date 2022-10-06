package com.example.desafio_spring.service;

import java.util.List;

import com.example.desafio_spring.model.Customer;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer createCustomer(Customer customer);
}
