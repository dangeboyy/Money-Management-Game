package model.customerFamily;

import controller.Data;
import controller.operations.ObjectFinder;
import controller.operations.fileOperations.FileUpdate;
import model.Request;
import model.RequestStatus;
import model.users.Customer;

@lombok.Data
public class GrandParent extends FamilyMember{


    public GrandParent(String userName, String password, int familyId) {
        super(userName, password, familyId);
        this.setMoney(100000);
        this.setNextApproverId(0);
        Data.grandParents.add(this);

    }

    @Override
    public String requestHandler(Request req) {
        if (req.getAmount()<=this.getMoney()){
            Customer customer = ObjectFinder.findCustomerFromCustomerId(req.getUserId());
            assert customer != null;
            double currentMoney = customer.getMoney();
            customer.setMoney(currentMoney+ req.getAmount());
            this.setMoney(this.getMoney()- req.getAmount());
            req.setStatus(RequestStatus.Approved);
            FileUpdate.updateFiles();
            return  req.getAmount()+ "$ is given by your Grandparent ";
        }else {
            req.setStatus(RequestStatus.Denied);
            FileUpdate.updateFiles();
            return "Money you requested is more than your Grandparent can give";
        }
    }


}
