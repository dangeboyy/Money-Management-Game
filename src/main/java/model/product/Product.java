package model.product;


import lombok.Data;
import model.Wood;

@Data
public class Product {
    private int productId;
    private double unitPrice;
    private int numberOfWoodsNeeded; //to build the product
    private int numberOfProduct; // for Flyweight Pattern it holds the numberOfItself instead of creating another same object


    public Product() {
        this.numberOfProduct=1;
    }
}