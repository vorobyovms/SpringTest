/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Customers;
import Entity.Personal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repositiries.CustomerRepository;

/**
 *
 * @author mihail
 */

@RestController

@RequestMapping("/customers")
public class AllCustomersControl {
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/all/")
    public List<Customers> findAll() {
        return customerRepository.findAll();
    }
}
