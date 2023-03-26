package controller.operations.fileOperations;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.Data;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWrite {
    public static void jsonWriteCustomer(){
        try  {
            FileWriter fileWriter = new FileWriter("customers.json");
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            fileWriter.write(gson.toJson(Data.customers));
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void jsonWriteSibling(){
        try  {
            FileWriter fileWriter = new FileWriter("siblings.json");
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            fileWriter.write(gson.toJson(Data.siblings));
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void jsonWriteFactoryBoss(){
        try  {
            FileWriter fileWriter = new FileWriter("factoryBoss.json");
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            fileWriter.write(gson.toJson(Data.factoryBosses));
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void jsonWriteParent(){
        try  {
            FileWriter fileWriter = new FileWriter("parents.json");
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            fileWriter.write(gson.toJson(Data.parents));
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void jsonWriteGrandParent(){
        try  {
            FileWriter fileWriter = new FileWriter("grandParents.json");
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            fileWriter.write(gson.toJson(Data.grandParents));
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void jsonWriteTableFactory(){
        try  {
            FileWriter fileWriter = new FileWriter("tableFactory.json");
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            fileWriter.write(gson.toJson(Data.woodenTableFactories));
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void jsonWriteBookshelfFactory(){
        try  {
            FileWriter fileWriter = new FileWriter("bookshelfFactory.json");
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            fileWriter.write(gson.toJson(Data.woodenBookshelfFactories));
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void jsonWriteWardrobeFactory(){
        try  {
            FileWriter fileWriter = new FileWriter("wardrobeFactory.json");
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            fileWriter.write(gson.toJson(Data.woodenWardrobeFactories));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
