package model.factories;

import lombok.Data;
import model.product.Product;
import model.product.WoodenTable;

@Data
public class WoodenTableFactory extends AbstractWoodFactory{

    public WoodenTableFactory() {
        super();
        this.setMoney(20000);
        this.setWoodStock(3500000);
        this.setFactoryId(1);
        this.setSalePrice((int) (new WoodenTable().getUnitPrice()+100));
        controller.Data.woodenTableFactories.add(this);
    }

    public WoodenTableFactory(int woodStock, double money) {
        super(woodStock, money);
        this.setFactoryId(1);
        this.setSalePrice((int) (new WoodenTable().getUnitPrice()+100));
        controller.Data.woodenTableFactories.add(this);
    }

    @Override
    public Product createProduct() {
        return new WoodenTable();
    }


}