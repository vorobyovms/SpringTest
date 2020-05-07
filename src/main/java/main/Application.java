package main;

import controllers.AllCrewControl;
import controllers.AllCustomersControl;
import controllers.AllFlightControl;
import controllers.AllPersonalControl;
import controllers.AllVehicleControl;
import controllers.TestInfo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EnableAutoConfiguration
@Import({ TestInfo.class, AllPersonalControl.class, AllCustomersControl.class, AllVehicleControl.class, AllFlightControl.class, AllCrewControl.class })
@EnableJpaRepositories("repositiries")
@ComponentScan("Entity")
@EntityScan("Entity")

public class Application {
    public static void main(String[] args) {
        
        SpringApplication.run(Application.class, args);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java");
	EntityManager entityManager = emf.createEntityManager();
        System.out.println("poperties = " + entityManager.getProperties());
        
    }
    


}
