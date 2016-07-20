package ShopingCenters;

import Dealers.Product;

/**
 * Created by Parapanov on 19/07/2016.
 */
public class MallShop extends ShopingCenter implements ChainTradingCenter{
    private static final int MALLSHOP_TAXES = 150;

    private Product[] products;

    public MallShop(String address, String workingTime, int area) {
        super(address, workingTime, MALLSHOP_TAXES, area);
    }
}
