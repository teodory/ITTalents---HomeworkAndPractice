package ShopingCenters;

import Dealers.Product;

/**
 * Created by Parapanov on 19/07/2016.
 */
public class Pavilion extends ShopingCenter implements SoleShopingCenter, ChainTradingCenter {
    private static final int PAVILION_TAXES = 50;

    private Product[] products;

    public Pavilion(String address, String workingTime, int area) {
        super(address, workingTime, PAVILION_TAXES, area);
    }
}
