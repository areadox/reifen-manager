/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.peddn.reifenmanager.mapping;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author peddn
 */

@Entity
public class Tire {

    @Id
    private ObjectId id;
    
    @Reference
    private Storage storage;
    
    private float treadDepth;
    private String position;
             
    public Tire(float treadDepth, String position) {
        this.treadDepth = treadDepth;
        this.position = position;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public float getTreadDepth() {
        return treadDepth;
    }

    public void setTreadDepth(float treadDepth) {
        this.treadDepth = treadDepth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
