package model.users;

import lombok.Data;
import model.Request;

import java.util.ArrayList;

@Data
public abstract class User{
    private int userId;
    private String userName;
    private String password;
    private double money;

    private ArrayList<Request> requests;
    private ArrayList<String> notifications;

    public User() {
    }

    public User(String userName, String password) {
        this.userId = controller.Data.users.size()+1;
        this.userName = userName;
        this.password = password;
        this.requests=new ArrayList<>();
        this.notifications=new ArrayList<>();
        controller.Data.users.add(this);
    }

    public void addRequest(Request request){
        this.getRequests().add(request);
    }

    public void addNotification(String message){
        this.getNotifications().add(message);
    }
    public void clearNotification(){
       this.getNotifications().clear();
    }



}