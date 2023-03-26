package model.product;

import model.Wood;

public class WoodenTable extends Product {


    public WoodenTable() {
        this.setProductId(1);
        this.setNumberOfWoodsNeeded(500);
        this.setUnitPrice(this.getNumberOfWoodsNeeded() * Wood.unitPrice);
    }
}