package net.peddn.reifenmanager;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import javafx.application.Application;
import net.peddn.reifenmanager.mapping.Customer;
import net.peddn.reifenmanager.mapping.Storage;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class ReifenManager {

    private Config config;
    
    private Gson gson;
    
    private Morphia morphia;

    public Datastore datastore;
    
    public static void main(String[] args) {
        ReifenManager reifenManager = new ReifenManager();
        
        reifenManager.loadConfig("config.json");
        reifenManager.createDatastore();
        reifenManager.exampleData();
        reifenManager.launchApp(args);
    }

    public ReifenManager() {
        this.gson = new Gson();        
        this.morphia = new Morphia();
        
        // tell Morphia where to find your classes
        // can be called multiple times with different packages or classes
        this.morphia.mapPackage("net.peddn.reifenmanager.mapping");
    }
    
    private void loadConfig(String jsonFile) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(jsonFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        
        this.config = gson.fromJson(br, Config.class);
    }
    
    private void createDatastore() {
        // create the Datastore connecting to the default port on the local host
        String collectionName = this.config.getCollectionName();
        this.datastore = this.morphia.createDatastore(new MongoClient(), collectionName);
        datastore.ensureIndexes();
    }

    private void exampleData() {
        
        Customer c1 = new Customer("Egon", "Müller");
        this.datastore.save(c1);
        
        Storage c1s1 = new Storage("12345");
        c1s1.setCustomer(c1);
        this.datastore.save(c1s1);
        
        Storage c1s2 = new Storage("31894");
        c1s2.setCustomer(c1);
        this.datastore.save(c1s2);
        
        c1.getStorages().add(c1s1);
        c1.getStorages().add(c1s2);
        this.datastore.save(c1);
   
    }
    
    private void launchApp(String[] args) {
        Application.launch(ReifenManagerApp.class, args);
    }
  
}
