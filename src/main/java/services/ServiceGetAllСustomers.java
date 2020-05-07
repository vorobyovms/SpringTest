/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entity.Customers;
import Entity.Personal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositiries.CustomerRepository;
import repositiries.PersonalRepository;

/**
 *
 * @author mihail
 */

//сервис клиенты

@Service
public class ServiceGetAllСustomers {
    
    @Autowired
    private final CustomerRepository customerRepository;
    
    public ServiceGetAllСustomers(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    
    public List<Customers> findAll(){
        return customerRepository.findAll();
    }
    
}
