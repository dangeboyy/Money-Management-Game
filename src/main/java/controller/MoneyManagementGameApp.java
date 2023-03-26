package controller;
import controller.operations.fileOperations.FileUpdate;
import view.LoginFrame;

public class MoneyManagementGameApp {
    public static void main(String[] args) {
        if (!FileUpdate.isExist()){
            Data.loadUserData();
            FileUpdate.updateFiles();
        }
        FileUpdate.readAllFiles();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
     
            }
        });

    }
}
