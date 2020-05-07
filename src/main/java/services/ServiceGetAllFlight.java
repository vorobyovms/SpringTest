/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entity.Personal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceGetAllFlight {
    @Autowired
    private final ServiceGetAllFlight flightRepository;
    
    public ServiceGetAllFlight(ServiceGetAllFlight flightRepository){
        this.flightRepository = flightRepository;
    }
    
    public List<Personal> findAll(){
        return flightRepository.findAll();
    }
}
