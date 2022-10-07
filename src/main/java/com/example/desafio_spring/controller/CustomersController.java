package com.example.desafio_spring.controller;

import com.example.desafio_spring.dto.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.desafio_spring.model.Customer;
import com.example.desafio_spring.service.CustomerService;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Path;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAll() {
        return new ResponseEntity<>(CustomerResponse.convertListToResponse(customerService.getAllCustomers()), HttpStatus.OK);
    }

    @GetMapping(path = "id/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) {
        return new ResponseEntity<>(CustomerResponse.convertToResponse(customerService.getCustomerById(id)), HttpStatus.OK);

    }

    @GetMapping(path = "{state}")
    public ResponseEntity<List<CustomerResponse>> filterByState(@PathVariable String state) {
        return new ResponseEntity<>(CustomerResponse.convertListToResponse(customerService.filterByState(state)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody Customer customer, UriComponentsBuilder uriComponentsBuilder) {
        Customer c = customerService.createCustomer(customer);
        URI uri = uriComponentsBuilder.path("/customers/id/{id}").buildAndExpand(c.getCustomerId()).toUri();
        return ResponseEntity.created(uri).body(CustomerResponse.convertToResponse(c));

    }
}
