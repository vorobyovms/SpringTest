/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entity.Vehicle;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import repositiries.VehicleRepository;

/**
 *
 * @author mihail
 */

@Service
public class ServiceGetAllVehicle {
    @Autowired
    private final VehicleRepository vehicleRepository;
    
    public ServiceGetAllVehicle(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    
    public List<Vehicle> findAll(){
        return vehicleRepository.findAll();
    }
    
    public boolean DeleteById(Long id){
        Optional<Vehicle> ressql = vehicleRepository.findById(id);
        Vehicle from_optional = ressql.get();
        vehicleRepository.delete(from_optional);
        
        return true;
    }

}
