/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Entity.Crew;
import Entity.Flight;
import java.util.List;
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
import repositiries.CrewRepository;

/**
 *
 * @author mihail
 */


// контроллер экипажей
@RestController

@RequestMapping("/crew")
public class CrewControl {
    @Autowired
    private CrewRepository crewRepository;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all/")
    public List<Crew> findAll() {
        return crewRepository.findAll();
    }
    
    //{"flight_id":1,"personal_idl":2}
    @PostMapping(value = "/add_crew")
    @ResponseStatus(HttpStatus.CREATED)
    public JSONObject addcrew(@RequestBody String input) {
        System.out.println("input = " + input);
        JSONParser parser = new JSONParser();
        JSONObject jsonfrom = null;
        boolean resoper = false;
        JSONObject forreturn = new JSONObject();
        forreturn.clear();
        try {
            jsonfrom = (JSONObject) parser.parse(input);
            Long flight_id = Long.parseLong(String.valueOf(jsonfrom.get("flight_id")));             // id поездки
            Long personal_idl = Long.parseLong(String.valueOf(jsonfrom.get("personal_idl")));       // id персонала
            Crew cc = new Crew();
            cc.setFlight_id(flight_id);
            cc.setPersonal_idl(personal_idl);
            crewRepository.save(cc);
            resoper = true;
            forreturn.put("operation", resoper);
        } catch(Exception ex) {
            System.out.println(ex);
            forreturn.put("operation", resoper);
        }
        
        return forreturn;
    }
    
    //{id:}
    @PostMapping(value = "/del_crew")
    @ResponseStatus(HttpStatus.CREATED)
    public JSONObject delcrew(@RequestBody String input) {
        System.out.println("input = " + input);
        JSONParser parser = new JSONParser();
        JSONObject jsonfrom = null;
        boolean resoper = false;
        JSONObject forreturn = new JSONObject();
        forreturn.clear();
        try {
            jsonfrom = (JSONObject) parser.parse(input);
            Long id = Long.parseLong(String.valueOf(jsonfrom.get("id")));
            Optional<Crew> ressql = crewRepository.findById(id);
            Crew from_optional = ressql.get();
            crewRepository.delete(from_optional);
            resoper = true;
            forreturn.put("operation", resoper);
        } catch(Exception ex) {
            System.out.println(ex);
            forreturn.put("operation", resoper);
        }
        
        return forreturn;
    }
}
