package model.product;

import model.Wood;


public class WoodenWardrobe extends Product {

    public WoodenWardrobe() {
        this.setProductId(3);
        this.setNumberOfWoodsNeeded(2500);
        this.setUnitPrice(this.getNumberOfWoodsNeeded() * Wood.unitPrice);
    }
}