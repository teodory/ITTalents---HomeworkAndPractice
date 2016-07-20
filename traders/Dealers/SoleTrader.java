package Dealers;

import Providers.SmallProvider;
import ShopingCenters.ShopingCenter;
import ShopingCenters.SoleShopingCenter;

import java.util.Random;

/**
 * Created by Parapanov on 19/07/2016.
 */
public class SoleTrader extends Dealer {

    private SmallProvider[] providers; // 5
    private SoleShopingCenter shopingCenter;

    public SoleTrader(String name, String address, double caliptal) {
        super(name, address, caliptal);
        this.setProviders();
    }

    @Override
    public void startTradingActivity() {
//        Order products
        Product[] orderedProducts = this.providers[new Random().nextInt(this.providers.length)]
                .orderProducts(this.getCaliptal() / 2, this);
//          Add products to the shop
        shopingCenter.addProducts(orderedProducts);
//        Print ordered products
        System.out.println("=================== Ordered Products ==================");
        this.printOrder(orderedProducts);

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
        double gain = this.shopingCenter.getProfit(this);
        return gain;
    }

    @Override
    protected void payTaxes() {
        double taxes =  this.getCaliptal() - ((ShopingCenter)this.shopingCenter).getTaxes()/12;
        this.addTotalPayedTaxes(taxes);
        this.setCaliptal(taxes);
    }

    private void setProviders() {
        this.providers = new SmallProvider[5];

        for (int i = 0; i < this.providers.length; i++) {
            this.providers[i] = new SmallProvider(
                    RandomDetails.getName(),
                    RandomDetails.getAddres(),
                    RandomDetails.getWorkingTime());
        }
    }

    public void setShopingCenter(SoleShopingCenter shopingCenter){
        this.shopingCenter = shopingCenter;
    }

}
