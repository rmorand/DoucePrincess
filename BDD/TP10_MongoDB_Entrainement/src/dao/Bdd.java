package dao;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Bdd {
    public static MongoDatabase connectToDatabase(String dbName) {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
        MongoClient client = MongoClients.create("mongodb+srv://del:admin@cluster0.hj4dj.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");
        MongoDatabase bdd = client.getDatabase(dbName);
        System.out.println("Connexion à MongoDB réussie !");
        return bdd;
    }
}
