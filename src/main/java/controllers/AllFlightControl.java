/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Flight;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repositiries.FlightRepository;

/**
 *
 * @author mihail
 */

@RestController

@RequestMapping("/flight")
public class AllFlightControl {
    @Autowired
    private FlightRepository flightlRepository;
    @GetMapping("/all/")
    public List<Flight> findAll() {
        System.out.println("aanswer = " + flightlRepository.findAll());
        return flightlRepository.findAll();
    }
}
