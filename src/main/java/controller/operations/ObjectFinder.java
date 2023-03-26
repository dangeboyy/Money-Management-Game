package controller.operations;

import controller.Data;
import model.Request;
import model.customerFamily.Sibling;
import model.factories.WoodenBookshelfFactory;
import model.factories.WoodenTableFactory;
import model.factories.WoodenWardrobeFactory;
import model.users.Customer;
import model.customerFamily.GrandParent;
import model.customerFamily.Parent;
import model.factories.AbstractWoodFactory;
import model.users.FactoryBoss;
import model.users.User;

public class ObjectFinder {
    public static Parent findParentFromFamilyId(int familyId) {
        for (Parent parent: Data.parents) {
            if (parent.getFamilyId()==familyId){
                return parent;
            }
        }
        System.out.println("No parent found!!");
        return null;
    }

    public static Customer findCustomerFromCustomerId(int customerId){
        for (Customer customer : Data.customers){
            if (customer.getUserId()==customerId){
                return customer;
            }
        }
        System.out.println("No customer found!!");
        return null;
    }


    public static GrandParent findGrandParentFromFamilyId(int familyId) {
        for (GrandParent grandParent: Data.grandParents) {
            if (grandParent.getFamilyId()==familyId){
                return grandParent;
            }
        }
        System.out.println("No grandParent found!!");
        return null;
    }

    public static AbstractWoodFactory findFactoryFromFactoryId(int factoryId) {
        for (AbstractWoodFactory factory: Data.factories) {
                if (factory.getFactoryId()==factoryId){
                    return factory;
                }
        }
        System.out.println("No factory found!!");
        return null;
    }


    public static User getUserFromName(String userName){
        User user = null;
        for (User u: Data.users) {
            if (u.getUserName().equals(userName)){
                user = u;
                return user;
            }
        }
        System.out.println("User not found");
        return user;

    }


    public static Sibling getSiblingFromId(int userId){
        for (Sibling sibling: Data.siblings) {
            if (sibling.getFamilyId()==userId){
                return sibling;
            }
        }
        System.out.println("Sibling not found");
        return null;
    }

    public static FactoryBoss findFactoryBossFromFactoryId(int factoryId){
        for (FactoryBoss factoryBoss: Data.factoryBosses) {
            if (factoryBoss.getResponsibleFactoryId()==factoryId){
                return factoryBoss;
            }
        }
        System.out.println("FactoryBoss not found");
        return null;
    }

    public static Request findRequestOfACustomer(int requestId, Customer customer){
        for (Request request: customer.getRequests()  ) {
            if (request.getRequestId()==requestId){
                return request;
            }
        }
        System.out.println("Request not found in the "+customer.getUserName());
        return null;
    }
    public static Request findRequestFromRequestId(FactoryBoss factoryBoss,int requestId){
        for(Request request:factoryBoss.getRequests()){
            if(request.getRequestId()==requestId){
                return request;
            }
        }
        return null;
    }






}