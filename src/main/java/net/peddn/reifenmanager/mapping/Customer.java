/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.peddn.reifenmanager.mapping;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author peddn
 */

@Entity
public class Customer {
    @Id
    private ObjectId id;
    
    private String firstname;
    private String lastname;
    
    @Reference
    private List<Storage> storages;
    
    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.storages = new ArrayList();
    }
    

    public ObjectId getId() {
        return id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Storage> getStorages() {
        return this.storages;
    }

}
