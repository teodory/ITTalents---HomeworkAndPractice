package models;

import products.Product;
import products.ProductByAmount;
import products.ProductByKilogram;

/**
 * Created by Parapanov on 20/07/2016.
 */
public class Shop {

    private String name;
    private String address;
    private double capital;
    private Product[] products;

    public Shop(String name, String address, int productsAmount) {
        this.name = name;
        this.address = address;
        this.capital = 0;

        if (productsAmount <= 0) {
            throw new IllegalArgumentException("Invalid products amount.");
        }

        this.products = new Product[productsAmount];
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.length() == 0) {
            throw new IllegalArgumentException("Invalid shop name.");
        }
        this.name = name;
    }

    private void setAddress(String address) {
        if (address == null || address.isEmpty() || address.length() == 0) {
            throw new IllegalArgumentException("Invalid shop address.");
        }
        this.address = address;
    }

    public void addProducts(Product... productsToAdd) {
        int freeInd = 0;

        // loop each new product
        PRODUCTS_TO_ADD:
        for (int i = 0; i < productsToAdd.length; i++) {

            // search for same product
            for (int j = 0; j < this.products.length; j++) {
                // if there is same product return amount
                if (products[j] != null && products[j].getName().equals(productsToAdd[i].getName())) {
                    products[j].returnProduct(productsToAdd[i].getCount());
                    continue PRODUCTS_TO_ADD;
                }
            }

            // search for free place to add (start from 0)
            while (this.products[freeInd] != null) {
                freeInd++;
//                System.out.println(freeInd + " ind");
                if (freeInd >= this.products.length) {
                    throw new UnsupportedOperationException("No free space in the shop");
                }
            }

            this.products[freeInd] = productsToAdd[i];
        }

        System.out.println("New products entered.");
    }

    public Product getProduct(String name, double wantedAmount) {
        if (wantedAmount <= 0) {
            throw new IllegalArgumentException("Invalid wanted product amount.");
        }

        Product toReturn;
        for (int i = 0; i < this.products.length; i++) {
            // find product with same name
            if (this.products[i] != null && this.products[i].getName().equals(name)) {

                //get available product count
                double productAmount = this.products[i].getCount();

                //the client want more than the available
                if (wantedAmount >= productAmount) {
                    if (wantedAmount > productAmount) {
                        System.out.println("You get only " + productAmount + " kg/count of " + name);
                    }

                    toReturn = this.products[i];
                    this.products[i] = null;
                    return toReturn;

                    // get the wanted product
                } else {

                    if (this.products[i] instanceof ProductByAmount) {
                        toReturn = new ProductByAmount(name, this.products[i].getPrice(), (int) wantedAmount);

                    } else {
                        toReturn = new ProductByKilogram(name, this.products[i].getPrice(), wantedAmount);

                    }


                    this.products[i].removeAmount(wantedAmount);

                    return toReturn;
                }
            }
        }

        throw new UnsupportedOperationException("No such product!");
    }

    public double payForProducts(Buyer buyer, Product... products) {
        double totalPrice = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null){
                totalPrice += products[i].getPrice() * products[i].getCount();
            }
        }

        if(buyer.getMoney() < totalPrice){
            throw new UnsupportedOperationException("The buyer don't have enough money");
        }

        this.capital += totalPrice;
        return totalPrice;
    }

    public void showShopStocks(){

        System.out.println("================ " + this.name + " Stock Info ================");
        for (int i = 0; i < this.products.length; i++) {
            if(this.products[i] != null){
                System.out.println(this.products[i]);
                System.out.println();
            }
        }
        System.out.println("================================================");
    }

}
