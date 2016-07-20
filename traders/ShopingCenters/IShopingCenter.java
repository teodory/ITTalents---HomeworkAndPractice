package ShopingCenters;

import Dealers.Dealer;
import Dealers.Product;

/**
 * Created by Parapanov on 20/07/2016.
 */
public interface IShopingCenter {

    void addProducts(Product[] products);

    double getProfit(Dealer dealer);

}
