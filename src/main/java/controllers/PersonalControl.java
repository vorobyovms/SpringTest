package controllers;

import Entity.Personal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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

}
