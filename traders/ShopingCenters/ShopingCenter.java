package ShopingCenters;

import Dealers.Dealer;
import Dealers.Product;

import java.util.Random;

/**
 * Created by Parapanov on 19/07/2016.
 */
public abstract class ShopingCenter implements IShopingCenter {

    private String address;
    private String workingTime;
    private int area;
    private int taxes;
    private Product[] products;

    public ShopingCenter(String address, String workingTime, int taxes, int area) {
        this.address = address;
        this.workingTime = workingTime;
        this.taxes = taxes;
        this.area = area;
    }

    public void addProducts(Product[] products){
        if (this.products == null){
            this.products = products;
        }

        this.products = Wharehouse.concatProducts(this.products, products);
    }

    public double getProfit(Dealer dealer){
        return sellProducts(products, dealer);
    }

    public int getTaxes() {
        return taxes;
    }

    public double sellProducts(Product[] products, Dealer dealer) {
        double gain = 0;
        int selledProducts = 0;

        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                if (new Random().nextBoolean()) {
                    gain += products[i].getPrice();
                    products[i] = null;
                    selledProducts++;
                }
            }
        }
        dealer.setSelledProductsCount(dealer.getSelledProductsCount() + selledProducts);
        return gain;
    }
}
