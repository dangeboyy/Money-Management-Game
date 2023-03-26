package model.factories;

import lombok.Data;

import model.product.Product;
import model.product.WoodenBookshelf;
import model.product.WoodenTable;

@Data
public class WoodenBookshelfFactory extends AbstractWoodFactory {



    public WoodenBookshelfFactory(int woodStock, double money) {
        super(woodStock, money);
        this.setFactoryId(3);
        this.setSalePrice((int) (new WoodenBookshelf().getUnitPrice() + 250));
        controller.Data.woodenBookshelfFactories.add(this);
    }

    public WoodenBookshelfFactory() {
        super();
        this.setMoney(18000);
        this.setWoodStock(3000000);
        this.setFactoryId(3);
        this.setSalePrice((int) (new WoodenBookshelf().getUnitPrice() + 250));
        controller.Data.woodenBookshelfFactories.add(this);
    }


    @Override
    public Product createProduct() {
        return new WoodenBookshelf();
    }


}