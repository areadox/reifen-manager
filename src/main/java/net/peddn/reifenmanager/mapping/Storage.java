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
public class Storage {
    
    @Id
    private ObjectId id;
    
    private String storageNumber;
    
    @Reference
    private Customer customer;
    
    @Reference
    private List<Tire> tires;
    
    public Storage(String storageNumber) {
        this.storageNumber = storageNumber;
        this.tires = new ArrayList();
    }

    public String getStorageNumber() {
        return storageNumber;
    }

    public void setStorageNumber(String storageNumber) {
        this.storageNumber = storageNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Tire> getTires() {
        return tires;
    }
 
}
