package com.example.desafio_spring.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.desafio_spring.dto.CustomerResponse;
import com.example.desafio_spring.exception.AlreadyExistentException;
import com.example.desafio_spring.exception.NotFoundException;
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
    public Customer getCustomerById(Long id) {
        Optional<Customer> customerOptional = customerRepo.getCustomerById(id);

        if(customerOptional.isEmpty())throw new NotFoundException("Customer not found");
        return customerOptional.get();
    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepo.getAllCustomers();

    }

    @Override
    public Customer createCustomer(Customer customer) {
        customerValidation(customer);
        return customerRepo.createCustomer(customer);
    }

    private void customerValidation(Customer customer) {
        List<Customer> customerList = getAllCustomers();
        for (Customer customerFromList : customerList) {
            if (customerFromList.getCpf().equals(customer.getCpf())) {
                throw new AlreadyExistentException("Customer already exist");
            }
        }
    }

    @Override
    public List<Customer> filterByState(String state) {
        List<Customer> customerList = getAllCustomers().stream()
                .filter(customer -> customer.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());

        if (customerList.isEmpty()) throw new NotFoundException("There are not any customers in this state: " + state);
        return customerList;
    }


}
