/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Columns;

/**
 *
 * @author mihail
 */
@Entity
@Table(name = "customers",schema = "public")
public class Customers implements Serializable {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOkpo() {
        return okpo;
    }

    public String getName() {
        return name;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column
    private String okpo;
    
    @Column
    private String name;
    
    
    
}
