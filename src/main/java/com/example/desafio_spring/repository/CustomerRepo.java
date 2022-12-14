package com.example.desafio_spring.repository;

import com.example.desafio_spring.exception.CreationFailureException;

import com.example.desafio_spring.exception.NotFoundException;
import com.example.desafio_spring.model.Customer;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepo {

    private final String linkFile = "src/main/resources/customers.json";

    /**
     * Método responsavel por retornar um cliente pelo id.
     * 
     * @param id > Numero criado para identificar cliente.
     * @return um customer.
     */
    public Optional<Customer> getCustomerById(Long id) {
        return getAllCustomers().stream()
                .filter(c -> c.getCustomerId() == id)
                .findFirst();
    }

    /**
     * Método responsável por retornar uma lista com todos os clientes
     *
     * @return List<Customer>
     */
    public List<Customer> getAllCustomers() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return Arrays.asList(mapper.readValue(new File(linkFile), Customer[].class));
        } catch (Exception e) {
            throw new NotFoundException("Empty product list");
        }
    }

    /**
     * Método responsável por salvar um novo cliente.
     *
     * @param customer -> novo cliente adicionado.
     * @return Customer — novo cliente criado.
     */
    public Customer createCustomer(Customer customer) {
        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        List<Customer> customerList = getAllCustomers();
        customerList = new ArrayList<>(customerList);
        customer.setCustomerId(customerList.get(customerList.size() - 1).getCustomerId() + 1);
        customerList.add(customer);

        try {
            writer.writeValue(new File(linkFile), customerList);
        } catch (Exception ex) {
            throw new CreationFailureException("Invalid creation attributes");
        }

        return customer;
    }
}
