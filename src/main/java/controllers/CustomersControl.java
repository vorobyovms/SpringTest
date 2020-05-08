/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Customers;
import Entity.Personal;
import java.util.List;
import java.util.Optional;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    // добавление клиента {"okpo":"3142911755","name":"FOP Vorobyov"}
    @PostMapping(value = "/add_customer")
    @ResponseStatus(HttpStatus.CREATED)
    public JSONObject addcustomer(@RequestBody String input) {
        JSONParser parser = new JSONParser();
        JSONObject jsonfrom = null;
        boolean resoper = false;
        JSONObject forreturn = new JSONObject();
        forreturn.clear();
        try {
            jsonfrom = (JSONObject) parser.parse(input);
            String okpo = String.valueOf(jsonfrom.get("okpo"));
            String name = String.valueOf(jsonfrom.get("name"));
            Customers cust = new Customers();
            cust.setName(name);
            cust.setOkpo(okpo);
            customerRepository.save(cust);
            resoper = true;
            forreturn.put("operation", resoper);
        } catch (ParseException ex) {
            System.out.println("convert json error");
            forreturn.put("operation", resoper);
        }
        return forreturn;
    }

    @PostMapping(value = "/del_customer")
    @ResponseStatus(HttpStatus.CREATED)
    public JSONObject delcustomer(@RequestBody String input) {
        JSONParser parser = new JSONParser();
        JSONObject jsonfrom = null;
        boolean resoper = false;
        JSONObject forreturn = new JSONObject();
        forreturn.clear();
        try {
            jsonfrom = (JSONObject) parser.parse(input);
            Long id = Long.parseLong(String.valueOf(jsonfrom.get("id")));
            Optional<Customers> ressql = customerRepository.findById(id);
            Customers from_optional = ressql.get();
            customerRepository.delete(from_optional);
            resoper = true;
            forreturn.put("operation", resoper);
        } catch (Exception ex) {
            System.out.println("convert json error");
            forreturn.put("operation", resoper);
        }

        return forreturn;
    }

}
