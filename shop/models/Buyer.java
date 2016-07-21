package models;

import products.Product;

/**
 * Created by Parapanov on 20/07/2016.
 */
public class Buyer {
    private Shop shop;
    private double money;
    private Product[] products;

    private Buyer(Shop shop, double money, int maxProductCount) {
        this.setShop(shop);
        this.setMoney(money);
        this.products = new Product[maxProductCount];
    }

    private void setShop(Shop shop) {
        if(shop == null){
            throw new IllegalArgumentException("Shop cannot be null.");
        }
        this.shop = shop;
    }

    private void setMoney(double money) {
        if (money <= 0){
            throw new IllegalArgumentException("Invalid money.");
        }
        this.money = money;
    }


}
