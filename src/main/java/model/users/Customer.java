package model.users;

import lombok.Data;
import model.product.Product;

import java.util.ArrayList;

@Data
public class Customer extends User {
    private ArrayList<Product> products;
    private int siblingId;




    public Customer(String userName, String password, int sibling) {
        super(userName, password);
        this.products=new ArrayList<>();
        this.setMoney(10000);
        this.siblingId =sibling;
        controller.Data.customers.add(this);
    }

    public Customer(String userName, String password) {
        super(userName, password);
        this.products=new ArrayList<>();
        this.setMoney(10000);
        controller.Data.customers.add(this);
    }
    

//    private void initProducts(){ //To find the type of the
//        for (int i = 0; i < this.products.size(); i++) {
//            if (this.products.get(i).getUnitPrice()==1000){
//                this.products.set(i,new WoodenTable());
//            }
//        }
//    }
}
