/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositiries;

import Entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mihail
 */
public interface CustomerRepository extends JpaRepository<Customers, Long>{
    
}
