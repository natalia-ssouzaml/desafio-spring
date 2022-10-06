package com.example.desafio_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio_spring.model.Customer;
import com.example.desafio_spring.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> creatCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }
}
