package model.product;

import lombok.Data;
import model.Wood;

@Data
public class WoodenBookshelf extends Product {

    public WoodenBookshelf() {
        this.setProductId(2);
        this.setNumberOfWoodsNeeded(1200);
        this.setUnitPrice(this.getNumberOfWoodsNeeded() * Wood.unitPrice);
        
    }
}