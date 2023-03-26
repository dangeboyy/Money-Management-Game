package controller.operations.userOperations;

import controller.operations.RollDice;
import controller.operations.fileOperations.FileUpdate;
import model.RequestType;
import controller.operations.ObjectFinder;
import model.Request;
import model.customerFamily.FamilyMember;
import model.factories.WoodenBookshelfFactory;
import model.factories.WoodenTableFactory;
import model.factories.WoodenWardrobeFactory;
import model.product.Product;
import model.product.WoodenBookshelf;
import model.product.WoodenTable;
import model.product.WoodenWardrobe;
import model.users.Customer;
import model.users.FactoryBoss;

public class CustomerOperations {
    public static String requestMoney(Customer customer, int moneyRequested) {
        Request request = new Request(customer.getUserId(), moneyRequested, RequestType.WishMoneyFromFamily);
        customer.getRequests().add(request);
        FamilyMember personReqToBeSend = ObjectFinder.getSiblingFromId(customer.getUserId());
        assert personReqToBeSend != null;
        return personReqToBeSend.requestHandler(request);
    }

    public static String buyWoodTable(Customer customer, int productAmount) {
        int salePrice = new WoodenTableFactory().getSalePrice();
        if (customer.getMoney() >= productAmount * salePrice) {
            Request request = new Request(customer.getUserId(), productAmount, RequestType.WoodTable);
            customer.setMoney(customer.getMoney() - (salePrice * request.getAmount()));
            customer.addRequest(request);
            FactoryBoss factoryBossToSendReq = ObjectFinder.findFactoryBossFromFactoryId(new WoodenTableFactory().getFactoryId());
            assert factoryBossToSendReq != null;
            factoryBossToSendReq.addRequest(request);
            sendNotificationToFactoryBoss(factoryBossToSendReq,customer.getUserName(),productAmount);
            FileUpdate.updateFiles();
            return "Your order is sent to head of Wooden Table Factory.";
        }
        return "You do not have enough money. You have to find money.";
    }

    public static String buyWoodWardrobe(Customer customer, int productAmount) {
        int salePrice = new WoodenWardrobeFactory().getSalePrice();
        if (customer.getMoney() >= productAmount * salePrice) {
            Request request = new Request(customer.getUserId(), productAmount, RequestType.WoodWardrobe);
            customer.setMoney(customer.getMoney() - salePrice * request.getAmount());
            customer.addRequest(request);
            FactoryBoss factoryBossToSendReq = ObjectFinder.findFactoryBossFromFactoryId(new WoodenWardrobeFactory().getFactoryId());
            assert factoryBossToSendReq != null;
            factoryBossToSendReq.addRequest(request);
            sendNotificationToFactoryBoss(factoryBossToSendReq,customer.getUserName(),productAmount);
            FileUpdate.updateFiles();
            return "Your order is sent to head of Wooden Wardrobe Factory.";
        }
        return "You do not have enough money. You have to find money.";
    }

    public static String buyWoodBookshelf(Customer customer, int productAmount) {
        int salePrice = new WoodenBookshelfFactory().getSalePrice();
        if (customer.getMoney() >= productAmount * salePrice) {
            Request request = new Request(customer.getUserId(), productAmount, RequestType.WoodBookshelf);
            customer.setMoney(customer.getMoney() - salePrice * request.getAmount());
            customer.addRequest(request);
            FactoryBoss factoryBossToSendReq = ObjectFinder.findFactoryBossFromFactoryId(new WoodenBookshelfFactory().getFactoryId());
            assert factoryBossToSendReq != null;
            factoryBossToSendReq.addRequest(request);
            sendNotificationToFactoryBoss(factoryBossToSendReq,customer.getUserName(),productAmount);
            FileUpdate.updateFiles();
            return "Your order is sent to head of Wooden Bookshelf Factory.";
        }
        return "You do not have enough money. You have to find money.";
    }

    private static void sendNotificationToFactoryBoss(FactoryBoss factoryBossToSendReq,String reqOwnerName,int reqAmount) {
        String notification = "You have product orders that needs to be handle(Request owner:"+reqOwnerName+",Request amount:"+reqAmount+")";
        factoryBossToSendReq.addNotification(notification);
    }


    public static String sellWoodenWardrobe(Customer customer, int productAmountToSell) {
        double currentMoney = customer.getMoney();
        int salePrice = new WoodenWardrobeFactory().getSalePrice();
        double earnedMoney = (salePrice + (salePrice * 0.1)) * productAmountToSell;
        for (Product product : customer.getProducts()) {
            if (product.getProductId() == new WoodenWardrobe().getProductId()) {
                int current = product.getNumberOfProduct();
                if (current >= productAmountToSell) {
                    product.setNumberOfProduct(current - productAmountToSell);
                    customer.setMoney(currentMoney + earnedMoney);
                    FileUpdate.updateFiles();
                    return "You earned " + earnedMoney + " $ from Wooden Wardrobe ";
                } else {
                    return "You do not have enough Wooden Wardrobe to sell";
                }
            }
        }
        return "You do not have any wooden wardrobe";
    }

    public static String sellWoodenBookshelf(Customer customer, int productAmountToSell) {
        double currentMoney = customer.getMoney();
        int salePrice = new WoodenBookshelfFactory().getSalePrice();
        double earnedMoney = (salePrice + (salePrice * 0.1)) * productAmountToSell;
        for (Product product : customer.getProducts()) {
            if (product.getProductId() == new WoodenBookshelf().getProductId()) {
                int current = product.getNumberOfProduct();
                if (current >= productAmountToSell) {
                    product.setNumberOfProduct(current - productAmountToSell);
                    customer.setMoney(currentMoney + earnedMoney);
                    FileUpdate.updateFiles();
                    return "You earned " + earnedMoney + " $ from Wooden Bookshelf ";
                    
                } else {
                    return "You do not have enough Wooden Bookshelf to sell";
                }
            }
        }
        return "You do not have any wooden bookshelf";
    }

    public static String sellWoodenTable(Customer customer, int productAmountToSell) {
        double currentMoney = customer.getMoney();
        int salePrice = new WoodenTableFactory().getSalePrice();
        double earnedMoney = (salePrice + (salePrice * 0.1)) * productAmountToSell; //0.1 = profit
        for (Product product : customer.getProducts()) {
            if (product.getProductId() == new WoodenTable().getProductId()) {
                int current = product.getNumberOfProduct();
                if (current >= productAmountToSell) {
                    product.setNumberOfProduct(current - productAmountToSell);
                    customer.setMoney(currentMoney + earnedMoney);
                    FileUpdate.updateFiles();
                    return "You earned " + earnedMoney + " $ from Wooden Table ";
                    
                } else {
                    return "You do not have enough Wooden Table to sell";
                }
            }
        }
        return "You do not have any wooden table";
    }

    public static int gamble(Customer customer, double amount, int guess) {
        double currentMoney = customer.getMoney();
        return diceGame(customer, amount, guess, currentMoney);


    }

    private static int diceGame(Customer customer, double amount, int guess, double currentMoney) {
        int dice = RollDice.roller();
        if (dice == guess) {
            customer.setMoney(currentMoney + (amount * 1.5));
            FileUpdate.updateFiles();
            return 0;
        } else {
            customer.setMoney(currentMoney - amount);
            FileUpdate.updateFiles();
            return dice-guess;
        }
    }


}