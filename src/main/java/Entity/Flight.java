/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mihail
 */


@Entity
@Table(name = "flight",schema = "public")
public class Flight implements Serializable {

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

    public Date getDate() {
        return date;
    }

    public Long getVehicle_id() {
        return vehicle_id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setVehicle_id(Long vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
    
    @Column
    private Date date;
    
    @Column
    private Long vehicle_id;
    
    @Column
    private String from;
    
    @Column
    private String to;
    
    @Column
    private Date end_date;
    
    
    
}
