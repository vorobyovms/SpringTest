/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Customers;
import Entity.Flight;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import repositiries.FlightRepository;

/**
 *
 * @author mihail
 */

//контроллер рейсов
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
    
    // {"date":"2020-02-19","vehicle_id":1,"from":"ZP","to":"KV","end_date":"2020-03-04"}
    // Добавление рейса
    
    @PostMapping(value = "/add_flight")
    @ResponseStatus(HttpStatus.CREATED)
    public JSONObject addflight(@RequestBody String input) {
        System.out.println("input = " + input);
        JSONParser parser = new JSONParser();
        JSONObject jsonfrom = null;
        boolean resoper = false;
        JSONObject forreturn = new JSONObject();
        forreturn.clear();
        
        try {
            jsonfrom = (JSONObject) parser.parse(input);
            String fdate = String.valueOf(jsonfrom.get("date"));
            Long vehicle_id = Long.parseLong(String.valueOf(jsonfrom.get("vehicle_id")));  //Это id транспорта
            String from_ = String.valueOf(jsonfrom.get("from"));
            String to = String.valueOf(jsonfrom.get("to"));
            String end_date = String.valueOf(jsonfrom.get("end_date"));
            //Time format
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());  //дата и время
            Date ddate1 = dateFormat.parse(fdate);
            Date ddate2 = dateFormat.parse(end_date);
            
            Flight ft = new Flight();
            ft.setDate(ddate1);
            ft.setEnd_date(ddate2);
            ft.setVehicle_id(vehicle_id);
            //ft.setFrom(from_);
            ft.setTo(to);
            flightlRepository.save(ft);
            resoper = true;
            forreturn.put("operation", resoper);

        } catch(Exception ex) {
            System.out.println("convert json error = " + ex );
            forreturn.put("operation", resoper);
        }
        
        return forreturn;
    }
    
    @PostMapping(value = "/del_flight")
    @ResponseStatus(HttpStatus.CREATED)
    public JSONObject delflight(@RequestBody String input) {
        JSONParser parser = new JSONParser();
        JSONObject jsonfrom = null;
        boolean resoper = false;
        JSONObject forreturn = new JSONObject();
        forreturn.clear();
        
        try {
            jsonfrom = (JSONObject) parser.parse(input);
            Long id = Long.parseLong(String.valueOf(jsonfrom.get("id")));
            Optional<Flight> ressql = flightlRepository.findById(id);
            Flight from_optional = ressql.get();
            flightlRepository.delete(from_optional);
            resoper = true;
            forreturn.put("operation", resoper);
        } catch(Exception ex) {
            System.out.println("convert json error");
            forreturn.put("operation", resoper);
        }
        
        return forreturn;
    }
    
}
