package model.customerFamily;

import lombok.Data;
import model.Request;
import model.users.User;

@Data
public abstract class FamilyMember extends User {
    private int nextApproverId;
    private int familyId;

    public FamilyMember() {

    }



    public FamilyMember(String userName, String password, int familyId) {
        super(userName, password);
        this.familyId=familyId;
    }

    public abstract String requestHandler(Request req);


}
