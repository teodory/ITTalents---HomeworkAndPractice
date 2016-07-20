package Dealers;

import Providers.SmallProvider;
import ShopingCenters.Wharehouse;

import java.util.Random;

/**
 * Created by Parapanov on 19/07/2016.
 */
public class AmbulateTrader extends Dealer{

    private SmallProvider provider;
    private Product[] products;

    public AmbulateTrader(String name, String address, double caliptal) {
        super(name, address, caliptal);

        this.provider = new SmallProvider(
                RandomDetails.getName(),
                RandomDetails.getAddres(),
                RandomDetails.getWorkingTime());

    }

    private void setProducts(Product[] products) {
        if (this.products == null){
            this.products = products;
        }

        this.products = Wharehouse.concatProducts(this.products, products);
    }

    @Override
    public void startTradingActivity() {
        //get list of ordered products
        Product[] products = this.provider.orderProducts(this.getCaliptal()/2, this);

        System.out.println("=================== Ordered Products ==================");

        // print products
        this.printOrder(products);
        //add products
        this.setProducts(products);

        //get profit from sell
        double profit = this.getProfit();
        System.out.println("Profit: " + profit * 0.3);
        // add the profit + 130%
        this.setCaliptal(this.getCaliptal() +  profit*1.3);

        //pay taxes
        payTaxes();
    }

    protected double getProfit() {
        this.setSelledProductsCount(0);
        double profit = sellProducts(this.products);
        return profit;
    }

    public double sellProducts(Product[] products) {
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
        this.setSelledProductsCount(selledProducts);
        return gain;
    }

    @Override
    protected void payTaxes() {
        //don't pay any taxes
    }

}
