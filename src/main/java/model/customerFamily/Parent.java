package model.customerFamily;

import controller.Data;
import controller.operations.ObjectFinder;
import controller.operations.fileOperations.FileUpdate;
import model.Request;
import model.RequestStatus;
import model.users.Customer;

@lombok.Data
public class Parent extends FamilyMember {


    public Parent(){}


    public Parent(String userName, String password, int familyId) {
        super(userName, password, familyId);
        this.setMoney(70000);
        GrandParent grandParent = ObjectFinder.findGrandParentFromFamilyId(this.getFamilyId());
        this.setNextApproverId(grandParent.getUserId());
        Data.parents.add(this);
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
            return  req.getAmount()+ "$ is given by your Parent";
        }else if(this.getNextApproverId()!=0){
            GrandParent nextApprover = ObjectFinder.findGrandParentFromFamilyId(this.getFamilyId());
            assert nextApprover != null;
            System.out.println("Your Parent is delegated your request to your GrandParent");
            return nextApprover.requestHandler(req);
        }
        return null;
    }
    

}
