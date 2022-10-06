package com.example.desafio_spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio_spring.model.Customer;
import com.example.desafio_spring.repository.CustomerRepo;
import com.example.desafio_spring.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepo.createCustomer(customer);
    }
    
}
