package controllers;

import Entity.Personal;
import Entity.Vehicle;
import java.util.List;
import java.util.Optional;
import org.json.simple.JSONObject;
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
import repositiries.PersonalRepository;

//контроль персонала
@RestController

@RequestMapping("/personal")
public class PersonalControl {

    @Autowired
    private PersonalRepository personalRepository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all/")
    public List<Personal> findAll() {
        System.out.println("aanswer = " + personalRepository.findAll());
        return personalRepository.findAll();
    }

    // {"id":1,"fsl":"Vorobyov Mikhaylo","rightsNumbet":"SU","seriesStraight":123456}
    //добавление персонала - на входе JSONObject
    @PostMapping(value = "/personal_add")
    @ResponseStatus(HttpStatus.CREATED)
    public JSONObject addpers(@RequestBody String input) {
        JSONParser parser = new JSONParser();
        JSONObject jsonfrom = null;
        boolean resoper = false;
        JSONObject forreturn = new JSONObject();
        forreturn.clear();
        try {
            jsonfrom = (JSONObject) parser.parse(input);
            String fsl = String.valueOf(jsonfrom.get("fsl"));
            String rightsNumbet = String.valueOf(jsonfrom.get("rightsNumbet"));
            Long seriesStraight = Long.parseLong(String.valueOf(jsonfrom.get("seriesStraight")));
            Personal pers = new Personal();
            pers.setFsl(fsl);
            pers.setRightsNumbet(rightsNumbet);
            pers.setSeriesStraight(seriesStraight);
            personalRepository.save(pers);
            resoper = true;
            forreturn.put("operation", resoper);
        } catch (ParseException ex) {
            System.out.println("error" + ex);
            forreturn.put("operation", resoper);
        }

        return forreturn;
    }

    //удаление персонала по ид - на входе JSONObject {"id":1}
    @PostMapping(value = "/personal_del")
    @ResponseStatus(HttpStatus.CREATED)
    public JSONObject addvehicle(@RequestBody String input) {
        JSONParser parser = new JSONParser();
        JSONObject jsonfrom = null;
        boolean resoper = false;
        JSONObject forreturn = new JSONObject();
        forreturn.clear();
        try {
            jsonfrom = (JSONObject) parser.parse(input);
            Long id_personal = Long.parseLong(String.valueOf(jsonfrom.get("id")));
            Optional<Personal> ressql = personalRepository.findById(id_personal);
            Personal from_optional = ressql.get();
            personalRepository.delete(from_optional);
            resoper = true;
            forreturn.put("operation", resoper);
        } catch (ParseException ex) {
            System.out.println("error" + ex);
            forreturn.put("operation", resoper);
        }

        return forreturn;
    }

}
