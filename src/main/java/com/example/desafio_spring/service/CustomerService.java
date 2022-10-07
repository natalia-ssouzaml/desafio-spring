package com.example.desafio_spring.service;

import java.util.List;

import com.example.desafio_spring.dto.CustomerResponse;
import com.example.desafio_spring.model.Customer;

public interface CustomerService {
    /**
     * Método responsavel por retornar cliente pelo id.
     *
     * @param id > gerado automaticamente na criação de um cliente.
     * @return um cliente.
     **/
    Customer getCustomerById(Long id);
    /**
     * Método responsável por retornar uma lista com todos os clientes
     *
     * @return Lista com todos os clientes
     */
    List<Customer> getAllCustomers();
    /**
     * Metodo responsavel por criar um novo cliente.
     *
     * @param customer > novo cliente recebido atraves do body.
     * @return o cliente criado.
     **/

    Customer createCustomer(Customer customer);
    /**
     * Método responsável por retornar uma lista de clientes de determinado estado passada por parâmetro
     *
     * @param state — Estado do cliente.
     * @return List<Customer> filtrado por estado
     */
    List<Customer> filterByState(String state);
}
