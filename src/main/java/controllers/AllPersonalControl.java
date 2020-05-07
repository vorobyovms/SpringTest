package controllers;

import Entity.Personal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repositiries.PersonalRepository;

@RestController

@RequestMapping("/personal")
public class AllPersonalControl {

    @Autowired
    private PersonalRepository personalRepository;
    @GetMapping("/all/")
    public List<Personal> findAll() {
        System.out.println("aanswer = " + personalRepository.findAll());
        return personalRepository.findAll();
    }

}
