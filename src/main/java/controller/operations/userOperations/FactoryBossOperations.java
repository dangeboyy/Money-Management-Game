package controller.operations.userOperations;

import controller.operations.ObjectFinder;
import controller.operations.fileOperations.FileUpdate;
import model.Request;
import model.RequestStatus;
import model.RequestType;
import model.Wood;
import model.factories.AbstractWoodFactory;
import model.factories.WoodenBookshelfFactory;
import model.factories.WoodenTableFactory;
import model.factories.WoodenWardrobeFactory;

import model.product.WoodenBookshelf;
import model.product.WoodenTable;
import model.product.WoodenWardrobe;
import model.users.Customer;
import model.users.FactoryBoss;

public class FactoryBossOperations {
    public static String buyWood(FactoryBoss factoryBoss,int amount){
        AbstractWoodFactory factory = ObjectFinder.findFactoryFromFactoryId(factoryBoss.getResponsibleFactoryId());
        assert factory != null;
        if (factory.getMoney()>=amount* Wood.unitPrice){
            int currentWoodStock = factory.getWoodStock();
            factory.setWoodStock(currentWoodStock+amount);
            factory.setMoney(factory.getMoney()-(amount*(Wood.unitPrice)));
            return amount + " woods is added to your factory ";
        }else{
            return "your factory do not have enough money to buy " + amount + " woods";
        }
    }
    public static String approveWoodBookshelfRequest(FactoryBoss factoryBoss,Request request){
        AbstractWoodFactory factory = ObjectFinder.findFactoryFromFactoryId(factoryBoss.getResponsibleFactoryId());
        assert factory != null;
        Customer reqOwner = ObjectFinder.findCustomerFromCustomerId(request.getUserId());
        assert reqOwner != null;
        int neededWoodedStock= (int) (request.getAmount() * new WoodenBookshelf().getNumberOfWoodsNeeded());
        if ((factory.getWoodStock()>=neededWoodedStock) && factoryBoss.getRequests().contains(request)){
            factory.setWoodStock(factory.getWoodStock()-neededWoodedStock);
            factory.sendProductToCustomer(request);
            factory.setMoney(factory.getMoney() + new WoodenBookshelfFactory().getSalePrice() * request.getAmount());
            return updateRequestStatus(request, reqOwner);
        }else{
            return "You do not have enough wood to make bookshelf. You should buy wood";
        }
    }

    public static String approveWoodWardrobeRequest(FactoryBoss factoryBoss,Request request){
        AbstractWoodFactory factory = ObjectFinder.findFactoryFromFactoryId(factoryBoss.getResponsibleFactoryId());
        assert factory != null;
        Customer reqOwner = ObjectFinder.findCustomerFromCustomerId(request.getUserId());
        assert reqOwner != null;
        int neededWoodedStock= (int) (request.getAmount() * new WoodenWardrobe().getNumberOfWoodsNeeded());
        if ((factory.getWoodStock()>=neededWoodedStock) && factoryBoss.getRequests().contains(request)){
            factory.setWoodStock(factory.getWoodStock()-neededWoodedStock);
            factory.sendProductToCustomer(request);
            factory.setMoney(factory.getMoney() + new WoodenWardrobeFactory().getSalePrice() * request.getAmount());
            return updateRequestStatus(request, reqOwner);
        }else{
            return "You do not have enough wood to make wardrobe. You should buy wood";
        }
    }



    public static String approveWoodTableRequest(FactoryBoss factoryBoss,Request request){
        AbstractWoodFactory factory = ObjectFinder.findFactoryFromFactoryId(factoryBoss.getResponsibleFactoryId());
        assert factory != null;
        Customer reqOwner = ObjectFinder.findCustomerFromCustomerId(request.getUserId());
        assert reqOwner != null;
        int neededWoodedStock= (int) (request.getAmount() * new WoodenTable().getNumberOfWoodsNeeded());
        if ((factory.getWoodStock()>=neededWoodedStock) && factoryBoss.getRequests().contains(request)){
            factory.setWoodStock(factory.getWoodStock()-neededWoodedStock);
            factory.sendProductToCustomer(request);
            factory.setMoney(factory.getMoney() + new WoodenTableFactory().getSalePrice() * request.getAmount());
            return updateRequestStatus(request, reqOwner);
        }else{
            return "You do not have enough wood to make table. You should buy wood";
        }
    }

    private static String updateRequestStatus(Request request, Customer reqOwner) {
        Request reqOwnerReq = ObjectFinder.findRequestOfACustomer(request.getRequestId(),reqOwner);
        assert reqOwnerReq != null;
        reqOwnerReq.setStatus(RequestStatus.Approved);
        request.setStatus(RequestStatus.Approved);
        FileUpdate.updateFiles();
        return request.getAmount() +" wooden tables is sent to " + reqOwner.getUserName();
    }

    public static String denyRequest(FactoryBoss factoryBoss,Request request){
        Customer reqOwner = ObjectFinder.findCustomerFromCustomerId(request.getUserId());
        assert reqOwner != null;
        if (factoryBoss.getRequests().contains(request)){
            Request reqOwnerReq = ObjectFinder.findRequestOfACustomer(request.getRequestId(),reqOwner);
            assert reqOwnerReq != null;
            reqOwnerReq.setStatus(RequestStatus.Denied);
            request.setStatus(RequestStatus.Denied);
            if (request.getRequestType() == RequestType.WoodBookshelf){
                refundWoodBookshelfMoney(request, reqOwner);
            }else if (request.getRequestType() == RequestType.WoodTable){
                refundWoodTableMoney(request, reqOwner);
            }else if (request.getRequestType() == RequestType.WoodWardrobe){
                refundWoodWardrobeMoney(request, reqOwner);
            }
            return "request has been denied";
        }else{
            FileUpdate.updateFiles();
            return "You do not have this request";
        }
    }

    private static void refundWoodWardrobeMoney(Request request, Customer reqOwner) {
        double refundMoney = request.getAmount() * new WoodenWardrobeFactory().getSalePrice();
        reqOwner.setMoney(reqOwner.getMoney() + refundMoney);
        reqOwner.addNotification(RequestType.WoodWardrobe + " request is denied " + refundMoney + "$ has been refunded.");
        FileUpdate.updateFiles();
    }

    private static void refundWoodTableMoney(Request request, Customer reqOwner) {
        double refundMoney = request.getAmount() * new WoodenTableFactory().getSalePrice();
        reqOwner.setMoney(reqOwner.getMoney() + refundMoney);
        reqOwner.addNotification(RequestType.WoodTable + " request is denied " + refundMoney + "$ has been refunded.");
        FileUpdate.updateFiles();
    }

    private static void refundWoodBookshelfMoney(Request request, Customer reqOwner) {
        double refundMoney = request.getAmount() * new WoodenBookshelfFactory().getSalePrice();
        reqOwner.setMoney(reqOwner.getMoney() + refundMoney);
        reqOwner.addNotification(RequestType.WoodBookshelf + " request is denied " + refundMoney + "$ has been refunded.");
        FileUpdate.updateFiles();
    }


}