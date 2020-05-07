/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Flight;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import repositiries.FlightRepository;

/**
 *
 * @author mihail
 */

@RestController

@RequestMapping("/flight")
public class FlightControl {
    @Autowired
    private FlightRepository flightlRepository;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all/")
    public List<Flight> findAll() {
        System.out.println("aanswer = " + flightlRepository.findAll());
        return flightlRepository.findAll();
    }
}
