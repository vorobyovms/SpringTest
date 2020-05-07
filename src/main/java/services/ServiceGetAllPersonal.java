package services;

import Entity.Personal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositiries.PersonalRepository;

@Service

public class ServiceGetAllPersonal {
    
    @Autowired
    private final PersonalRepository personalRepository;
    
    public ServiceGetAllPersonal(PersonalRepository personalRepository){
        this.personalRepository = personalRepository;
    }
    
    public List<Personal> findAll(){
        return personalRepository.findAll();
    }
}
