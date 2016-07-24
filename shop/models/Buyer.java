package models;

import products.Product;

/**
 * Created by Parapanov on 20/07/2016.
 */
public class Buyer {

    private Shop shop;
    private double money;
    private Product[] products;

    public Buyer(Shop shop, double money, int maxProductCount) {
        this.setShop(shop);
        this.setMoney(money);
        this.products = new Product[maxProductCount];
    }

    public double getMoney() {
        return money;
    }

    private void setShop(Shop shop) {
        if (shop == null) {
            throw new IllegalArgumentException("Shop cannot be null.");
        }
        this.shop = shop;
    }

    private void setMoney(double money) {
        if (money <= 0) {
            throw new IllegalArgumentException("Invalid money.");
        }
        this.money = money;
    }

    public void addProductInBasket(String productName, double amount) {
        if(this.shop == null){
            throw new UnsupportedOperationException("The buyer is out of the shop");
        }

        int index = findFreeIndex();
        if (index == -1) {
            throw new UnsupportedOperationException("No free space in the basket");
        }

        this.products[index] = this.shop.getProduct(productName, amount);
    }

    public void removeProductFromBasket(String productName){
        if(this.shop == null){
            throw new UnsupportedOperationException("The buyer is out of the shop.");
        }

        for (int i = 0; i < this.products.length; i++) {

            if(this.products[i] != null && this.products[i].getName().equals(productName)){
                this.shop.addProducts(this.products[i]);
                this.products[i] = null;
                return;
            }
        }

        throw new UnsupportedOperationException("No such product in the basket.");
    }

    private int findFreeIndex() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void payForProducts(){
        if(this.shop == null){
            throw new UnsupportedOperationException("The buyer is out of the shop");
        }

        double moneyToPay = this.shop.payForProducts(this, this.products.clone());

        this.money -= moneyToPay;
    }
}
