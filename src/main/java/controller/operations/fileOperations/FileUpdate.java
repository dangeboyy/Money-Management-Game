package controller.operations.fileOperations;

import controller.Data;
import java.io.File;

public class FileUpdate {
    public static void updateFiles(){
        
        writeAllFiles();
        Data.clearAll();
        readAllFiles();
       
    }
    public static void readAllFiles(){
        
        JsonRead.readJsonGrandParent();
        JsonRead.readJsonParent();
        JsonRead.readJsonSiblings();
        JsonRead.readJsonFactoryBoss();
        JsonRead.readJsonCustomer();
        JsonRead.readJsonWoodenTable();
        JsonRead.readJsonWoodenBookshelf();
        JsonRead.readJsonWoodenWardrobe();
        Data.fillUserList();
        Data.fillFactoryList();
        Data.updateIdList();
        
    }
    public static void writeAllFiles(){
         JsonWrite.jsonWriteCustomer();
        JsonWrite.jsonWriteGrandParent();
        JsonWrite.jsonWriteFactoryBoss();
        JsonWrite.jsonWriteParent();
        JsonWrite.jsonWriteSibling();
        JsonWrite.jsonWriteBookshelfFactory();
        JsonWrite.jsonWriteWardrobeFactory();
        JsonWrite.jsonWriteTableFactory();
    }
    public static boolean isExist(){

        return new File("customers.json").exists() && new File("grandParents.json").exists()
                && new File("parents.json").exists() && new File("siblings.json").exists()
                && new File("factoryBoss.json").exists() && new File("wardrobeFactory.json").exists()
                && new File("tableFactory.json").exists() && new File("bookshelfFactory.json").exists() ;

    }
}
