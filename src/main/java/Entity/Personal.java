/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "personal",schema = "public")
public class Personal implements Serializable  {

    public Long getId() {
        return id;
    }

    public String getFsl() {
        return FSL;
    }

    public String getRightsNumbet() {
        return rightsnumber;
    }

    public Long getSeriesStraight() {
        return seriesstraight;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFsl(String FSL) {
        this.FSL = FSL;
    }

    public void setRightsNumbet(String rightsNumbet) {
        this.rightsnumber = rightsnumber;
    }

    public void setSeriesStraight(Long seriesStraight) {
        this.seriesstraight = seriesstraight;
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String FSL;
    
    @Column
    private String rightsnumber;
    
    @Column
    private Long seriesstraight;

}
