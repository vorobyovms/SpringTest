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
import javax.persistence.Table;

/**
 *
 * @author mihail
 */


// транспорт

@Entity
@Table(name = "vehicle",schema = "public")
public class Vehicle implements Serializable {

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

    public String getName() {
        return name;
    }

    public Double getMile_age() {
        return mile_age;
    }

    public Long getCarrying_capacity() {
        return carrying_capacity;
    }

    public Long getYear_issue() {
        return year_issue;
    }

    public Double getEngine_volume() {
        return engine_volume;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMile_age(Double mile_age) {
        this.mile_age = mile_age;
    }

    public void setCarrying_capacity(Long carrying_capacity) {
        this.carrying_capacity = carrying_capacity;
    }

    public void setYear_issue(Long year_issue) {
        this.year_issue = year_issue;
    }

    public void setEngine_volume(Double engine_volume) {
        this.engine_volume = engine_volume;
    }
    
    @Column
    private String name;            //название авто
    
    @Column
    private Double mile_age;         //сколько км прошли
    
    @Column
    private Long carrying_capacity;     //грузоподьемность
    
    @Column
    private Long year_issue;            //год выпуска
    
    @Column
    private Double engine_volume;       //обьем двигателя
    
    
    
    
    
    
}
