/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Entity.Crew;
import Entity.Personal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositiries.CrewRepository;

/**
 *
 * @author mihail
 */

@Service
public class ServiceGetAllCrew {
    @Autowired
    private final CrewRepository crewRepository;
    
    public ServiceGetAllCrew(CrewRepository crewRepository){
        this.crewRepository = crewRepository;
    }
    
    public List<Crew> findAll(){
        return crewRepository.findAll();
    }
}
