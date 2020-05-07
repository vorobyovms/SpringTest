/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "personal")
public class Personal implements Serializable  {

    public Long getId() {
        return id;
    }

    public String getFsl() {
        return fsl;
    }

    public String getRightsNumbet() {
        return rightsNumbet;
    }

    public Long getSeriesStraight() {
        return seriesStraight;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFsl(String fsl) {
        this.fsl = fsl;
    }

    public void setRightsNumbet(String rightsNumbet) {
        this.rightsNumbet = rightsNumbet;
    }

    public void setSeriesStraight(Long seriesStraight) {
        this.seriesStraight = seriesStraight;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String fsl;
    
    @Column
    private String rightsNumbet;
    
    @Column
    private Long seriesStraight;

}
