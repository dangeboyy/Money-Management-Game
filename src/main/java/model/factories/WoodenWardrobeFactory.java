package model.factories;

import lombok.Data;


import model.product.Product;
import model.product.WoodenTable;
import model.product.WoodenWardrobe;

@Data
public class WoodenWardrobeFactory extends AbstractWoodFactory {

    public WoodenWardrobeFactory(int woodStock, double money) {
        super(woodStock, money);
        this.setFactoryId(2);
        this.setSalePrice((int) (new WoodenWardrobe().getUnitPrice() + 500));
        controller.Data.woodenWardrobeFactories.add(this);

    }

    public WoodenWardrobeFactory() {
        super();
        this.setMoney(25000);
        this.setWoodStock(4500000);
        this.setFactoryId(2);
        this.setSalePrice((int) (new WoodenWardrobe().getUnitPrice() + 500));
        controller.Data.woodenWardrobeFactories.add(this);
    }

    @Override
    public Product createProduct() {
        return new WoodenWardrobe();
    }

}