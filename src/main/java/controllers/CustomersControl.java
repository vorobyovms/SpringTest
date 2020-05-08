/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Customers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import repositiries.CustomerRepository;

/**
 *
 * @author mihail
 */


//контроллер клиентов
@RestController

@RequestMapping("/customers")
public class CustomersControl {
    @Autowired
    private CustomerRepository customerRepository;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all/")
    public List<Customers> findAll() {
        return customerRepository.findAll();
    }
}
