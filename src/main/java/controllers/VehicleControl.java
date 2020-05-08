/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Vehicle;
import java.util.List;
import java.util.Optional;
import org.json.simple.*;
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
import repositiries.VehicleRepository;
import services.ServiceGetAllVehicle;

/**
 *
 * @author mihail
 */
//КОНТРОЛЛЕР транспорта
@RestController

@RequestMapping("/vehical")
public class VehicleControl {

    @Autowired
    private VehicleRepository vehicleRepository;

    //получить список всех транспортных средств
    @GetMapping("/all/")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Vehicle> findAll() {
        List<Vehicle> result = vehicleRepository.findAll();
        return result;
    }

    //поиск по параметру id  которые передали в JSON обьекте
    @PostMapping(value = "/selectcustom_by_id")
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle findcustom(@RequestBody String input) {
        JSONParser parser = new JSONParser();
        JSONObject jsonfrom = null;
        try {
            jsonfrom = (JSONObject) parser.parse(input);
        } catch (ParseException ex) {
            System.out.println("convert json error");
        }

        Long id_vehicle = Long.parseLong(String.valueOf(jsonfrom.get("id")));
        Optional<Vehicle> ressql = vehicleRepository.findById(id_vehicle);
        Vehicle from_optional = ressql.get();
        return from_optional;
    }

    //добавление транспорта
    /*
       {"name":"Volva1","mile_age":500000.0,"carrying_capacity":600,"year_issue":2012,"engine_volume":100.0}
     */
    @PostMapping(value = "/add_vehicle")
    @ResponseStatus(HttpStatus.CREATED)
    public JSONObject addvehicle(@RequestBody String input) {
        JSONParser parser = new JSONParser();
        JSONObject jsonfrom = null;
        boolean resoper = false;
        JSONObject forreturn = new JSONObject();
        forreturn.clear();
        try {
            jsonfrom = (JSONObject) parser.parse(input);
            String name = String.valueOf(jsonfrom.get("name"));
            Double mile_age = Double.parseDouble(String.valueOf(jsonfrom.get("mile_age")));
            Long carrying_capacity = Long.parseLong(String.valueOf(jsonfrom.get("carrying_capacity")));
            Long year_issue = Long.parseLong(String.valueOf(jsonfrom.get("year_issue")));
            Double engine_volume = Double.parseDouble(String.valueOf(jsonfrom.get("engine_volume")));

            //сохранение
            Vehicle vhcl = new Vehicle();
            vhcl.setEngine_volume(engine_volume);
            vhcl.setYear_issue(year_issue);
            vhcl.setCarrying_capacity(carrying_capacity);
            vhcl.setMile_age(mile_age);
            vhcl.setName(name);
            vehicleRepository.save(vhcl);
            resoper = true;
            forreturn.put("operation", resoper);
        } catch (ParseException ex) {
            System.out.println("convert json error");
            forreturn.put("operation", resoper);
        }

        return forreturn;

    }

    //удаление по id - на вход дается JSONObject с параметром id
    @PostMapping(value = "/del_vehicle")
    @ResponseStatus(HttpStatus.CREATED)
    public JSONObject delvehicle(@RequestBody String input) {
        JSONParser parser = new JSONParser();
        JSONObject jsonfrom = null;
        boolean resoper = false;
        JSONObject forreturn = new JSONObject();
        forreturn.clear();
        try {
            jsonfrom = (JSONObject) parser.parse(input);
            Long id_vehicle = Long.parseLong(String.valueOf(jsonfrom.get("id")));
            Optional<Vehicle> ressql = vehicleRepository.findById(id_vehicle);
            Vehicle from_optional = ressql.get();
            vehicleRepository.delete(from_optional);
            resoper = true;
            forreturn.put("operation", resoper);
        } catch (ParseException ex) {
            System.out.println("convert json error" + ex);
            forreturn.put("operation", resoper);
        }

        return forreturn;
    }

    //удаление по id - на вход дается JSONObject с параметром id через интерфейс 
    @PostMapping(value = "/del_vehicle1")
    @ResponseStatus(HttpStatus.CREATED)
    public JSONObject delvehicle1(@RequestBody String input) {
        ServiceGetAllVehicle service_ = new ServiceGetAllVehicle(vehicleRepository);
        JSONParser parser = new JSONParser();
        JSONObject jsonfrom = null;
        boolean resoper = false;
        JSONObject forreturn = new JSONObject();
        forreturn.clear();
        try {
            jsonfrom = (JSONObject) parser.parse(input);
            Long id_vehicle = Long.parseLong(String.valueOf(jsonfrom.get("id")));
            boolean result = service_.DeleteById(id_vehicle);
            forreturn.put("operation", result);
        } catch (ParseException ex) {
            System.out.println("convert json error");
            forreturn.put("operation", resoper);
        }
        
        return forreturn;

    }

}
