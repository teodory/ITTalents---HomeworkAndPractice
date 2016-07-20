package Dealers;

import Providers.Provider;
import Providers.SmallProvider;
import ShopingCenters.ChainTradingCenter;
import ShopingCenters.ShopingCenter;

import java.util.Random;

/**
 * Created by Parapanov on 19/07/2016.
 */
public class ChainTrader extends Dealer {

    private Provider[] providers; // 15
    private ChainTradingCenter[] shopingCenters; //10

    public ChainTrader(String name, String address, double caliptal) {
        super(name, address, caliptal);
        this.setProviders();
    }

    @Override
    public void startTradingActivity() {
        if(shopingCenters != null) {
            for (int i = 0; i < shopingCenters.length; i++) {
                System.out.println("=================== Ordered Products ==================");
                Product[] orderedProducts = this.providers[new Random().nextInt(this.providers.length)]
                        .orderProducts(this.getCaliptal() / 2, this);
                shopingCenters[i].addProducts(orderedProducts);

                this.printOrder(orderedProducts);
                System.out.println();
            }

            double profit = getProfit();
            System.out.println("Profit: " + profit * 0.3);
            this.setCaliptal(this.getCaliptal() + profit*1.3);

            payTaxes();
        }
    }

    @Override
    protected void payTaxes() {
        double totalTaxes = 0;
        for (int i = 0; i < shopingCenters.length; i++) {
            double shopTaxes = ((ShopingCenter)shopingCenters[i]).getTaxes();
            this.setCaliptal( this.getCaliptal() - (shopTaxes/12)) ;
            totalTaxes += shopTaxes;
        }
        this.addTotalPayedTaxes(totalTaxes);
    }

    protected double getProfit() {
        double gain = 0;
        for (int i = 0; i < this.shopingCenters.length; i++) {
            gain += (shopingCenters[i]).getProfit(this);
        }

        return gain;
    }

    private void setProviders() {
        this.providers = new SmallProvider[15];

        for (int i = 0; i < this.providers.length; i++) {
            this.providers[i] = new SmallProvider(
                    RandomDetails.getName(),
                    RandomDetails.getAddres(),
                    RandomDetails.getWorkingTime());
        }
    }

    public void setShopingCenters (ChainTradingCenter[] shopingCenters){
        this.shopingCenters = shopingCenters;
    }
}
