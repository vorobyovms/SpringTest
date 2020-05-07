/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Personal;
import Entity.Vehicle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repositiries.PersonalRepository;
import repositiries.VehicleRepository;

/**
 * 
 * @author mihail
 */

//ТРАНСПОРТ КОНТРОЛЛЕР

@RestController

@RequestMapping("/vehical")
public class AllVehicleControl {
    
    @Autowired
    private VehicleRepository vehicleRepository;
    @GetMapping("/all/")
    public List<Vehicle> findAll() {
        System.out.println("aanswer = " + vehicleRepository.findAll());
        return vehicleRepository.findAll();
    }
}
