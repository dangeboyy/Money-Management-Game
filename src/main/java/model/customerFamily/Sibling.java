package model.customerFamily;

import controller.Data;
import controller.operations.ObjectFinder;
import controller.operations.fileOperations.FileUpdate;
import model.Request;
import model.RequestStatus;
import model.users.Customer;

@lombok.Data
public class Sibling extends FamilyMember{

    public Sibling() {

    }

    public Sibling(String userName, String password, int familyId) {
        super(userName, password, familyId);
        this.setMoney(40000);
        Parent parent = ObjectFinder.findParentFromFamilyId(this.getFamilyId());
        assert parent != null;
        this.setNextApproverId(parent.getNextApproverId());
        Data.siblings.add(this);
    }

    @Override
    public String requestHandler(Request req) {
        if (req.getAmount() <= this.getMoney()) {
            Customer customer = ObjectFinder.findCustomerFromCustomerId(req.getUserId());
            assert customer != null;
            double currentMoney = customer.getMoney();
            customer.setMoney(currentMoney + req.getAmount());
            this.setMoney(this.getMoney()- req.getAmount());
            req.setStatus(RequestStatus.Approved);
            FileUpdate.updateFiles();
            return  req.getAmount()+ "$ is given by your Sibling";
        } else if (this.getNextApproverId() != 0) {
            Parent nextApprover = ObjectFinder.findParentFromFamilyId(this.getFamilyId());
            assert nextApprover != null;
            System.out.println("Your Sibling is delegated your request to your Parent");
            return nextApprover.requestHandler(req);
        }
        return null;
    }

}
