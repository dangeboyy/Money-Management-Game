package model;

import lombok.Data;

@Data
//This class is used for money from Family Members
public class Request {
     private int requestId;
    private int userId; //user that requests
    private double amount;
    private RequestStatus status;
    private RequestType requestType;

    public Request(int userId, double amount,RequestType requestType) {
        this.requestId= ++controller.Data.availableIdForRequest;
        this.userId = userId;
        this.amount = amount;
        this.requestType=requestType;
        this.status= RequestStatus.Waiting;
    }

}
