package model.factories;


import controller.operations.ObjectFinder;
import controller.operations.TransportationMistake;
import lombok.Data;
import model.product.WoodenTable;
import model.users.Customer;
import model.product.Product;
import model.Request;

@Data
public abstract class AbstractWoodFactory {
    private int woodStock; //number of wood
    private double money;     //money that factory have
    private int factoryId;
    private int salePrice;



    public AbstractWoodFactory(int woodStock, double money) {
        this.woodStock = woodStock;
        this.money = money;
        controller.Data.factories.add(this);
    }

    public AbstractWoodFactory() {
        controller.Data.factories.add(this);
    }

    //Creating the wooden product
    public abstract Product createProduct();


    //sending to the customer's product inventory list
    public void sendProductToCustomer(Request req){
        Customer reqOwner = ObjectFinder.findCustomerFromCustomerId(req.getUserId());
        Product createdProduct = createProduct();
        assert reqOwner != null;
        if (reqOwner.getProducts()!=null){
            addProductToCustomersInventory(req, reqOwner, createdProduct);
        }else{
            System.out.println("products is null");
        }
    }

    private void addProductToCustomersInventory(Request req, Customer reqOwner, Product createdProduct) {
        int sizeOfProductList=reqOwner.getProducts().size();
        double ratio = TransportationMistake.ratioOfBrokenProducts();
        System.out.println("%" + ratio);
        int brokenProductNumber = (int) (ratio * req.getAmount());
        int unBrokenProductNumber = (int) (req.getAmount() - brokenProductNumber);
        for (int i = 0; i < sizeOfProductList; i++) {
            if (reqOwner.getProducts().get(i).getProductId()==createdProduct.getProductId()){
                int currentNumberOfProduct=reqOwner.getProducts().get(i).getNumberOfProduct();
                reqOwner.getProducts().get(i).setNumberOfProduct(currentNumberOfProduct+unBrokenProductNumber);
                String notification="You ordered "+ req.getAmount()+ " " + createdProduct.getClass().getSimpleName() + " but "
                + brokenProductNumber + " of them were broken during transportation.";
        reqOwner.addNotification(notification);
                return;
            }
            
        }
            createdProduct.setNumberOfProduct(unBrokenProductNumber);
            reqOwner.getProducts().add(createdProduct);
        
        String notification="You ordered "+ req.getAmount()+ " " + createdProduct.getClass().getSimpleName() + " but "
                + brokenProductNumber + " of them were broken during transportation.";
        reqOwner.addNotification(notification);
    }
}