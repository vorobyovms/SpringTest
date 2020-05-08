/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author mihail
 */

//Экипаж

@Entity
public class Crew implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlight_id() {
        return flight_id;
    }

    public Long getPersonal_idl() {
        return personal_id;
    }

    public void setFlight_id(Long flight_id) {
        this.flight_id = flight_id;
    }

    public void setPersonal_idl(Long personal_id) {
        this.personal_id = personal_id;
    }
    
    @Column
    private Long flight_id;
    
    @Column
    private Long personal_id;

}
