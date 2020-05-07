/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entity.Customers;
import Entity.Vehicle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositiries.CustomerRepository;
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
}
