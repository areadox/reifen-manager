package net.peddn.reifenmanager;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class ReifenManager {

    private Morphia morphia = new Morphia();

    public Datastore datastore;
    
    public static void main(String[] args) {
        ReifenManager reifenManager = new ReifenManager();
        reifenManager.createDatastore();
    }

    public ReifenManager() {

        // tell Morphia where to find your classes
        // can be called multiple times with different packages or classes
        //ReifenManager.MORPHIA.mapPackage("org.mongodb.morphia.example");

    }
    
    private void createDatastore() {
        // create the Datastore connecting to the default port on the local host
        this.datastore = this.morphia.createDatastore(new MongoClient(), "reifenmanager");
        datastore.ensureIndexes();
    }

}
