/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entity.Flight;
import Entity.Personal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositiries.FlightRepository;

@Service
public class ServiceGetAllFlight {
    @Autowired
    private final FlightRepository flightRepository;
    
    public ServiceGetAllFlight(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }
    
    public List<Flight> findAll(){
        return flightRepository.findAll();
    }
}
