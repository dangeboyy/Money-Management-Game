package controller.operations.fileOperations;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.Data;
import model.customerFamily.GrandParent;
import model.customerFamily.Parent;
import model.customerFamily.Sibling;
import model.factories.WoodenBookshelfFactory;
import model.factories.WoodenTableFactory;
import model.factories.WoodenWardrobeFactory;
import model.users.Customer;
import model.users.FactoryBoss;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonRead {
    public static void readJsonCustomer(){
        try {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("customers.json"));
            // convert JSON string to User object
            Data.customers = gson.fromJson(reader, new TypeToken<List<Customer>>() {}.getType());
            // close reader
            reader.close();
        } catch (Exception ex) {
        }
    }

    public static void readJsonFactoryBoss(){
        try {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("factoryBoss.json"));
            // convert JSON string to User object
            Data.factoryBosses = gson.fromJson(reader, new TypeToken<List<FactoryBoss>>() {}.getType());
            // close reader
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void readJsonSiblings(){
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("siblings.json"));
            Data.siblings = gson.fromJson(reader, new TypeToken<List<Sibling>>() {}.getType());
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void readJsonParent(){
        try {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("parents.json"));
            // convert JSON string to User object
            Data.parents = gson.fromJson(reader, new TypeToken<List<Parent>>() {}.getType());
            // close reader
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public static void readJsonGrandParent(){
        try {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("grandParents.json"));
            // convert JSON string to User object
            Data.grandParents = gson.fromJson(reader, new TypeToken<List<GrandParent>>() {}.getType());
            // close reader
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void readJsonWoodenTable(){
        try {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("tableFactory.json"));
            // convert JSON string to User object
            Data.woodenTableFactories = gson.fromJson(reader, new TypeToken<List<WoodenTableFactory>>() {}.getType());
            // close reader
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void readJsonWoodenBookshelf(){
        try {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("bookshelfFactory.json"));
            // convert JSON string to User object
            Data.woodenBookshelfFactories = gson.fromJson(reader, new TypeToken<List<WoodenBookshelfFactory>>() {}.getType());
            // close reader
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void readJsonWoodenWardrobe(){
        try {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("wardrobeFactory.json"));
            // convert JSON string to User object
            Data.woodenWardrobeFactories = gson.fromJson(reader, new TypeToken<List<WoodenWardrobeFactory>>() {}.getType());
            // close reader
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
