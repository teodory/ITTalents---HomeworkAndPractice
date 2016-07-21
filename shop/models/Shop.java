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

    private Shop(String name, String address, int productsAmount) {
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

    public void addProducts(Product... products) {
        int freeInd = 0;

        for (int i = 0; i < products.length; i++) {
            while (products[freeInd] != null) {
                freeInd++;
                if (freeInd == this.products.length) {
                    throw new UnsupportedOperationException("No free space in the shop");
                }
            }

            this.products[freeInd] = products[i];
        }

        System.out.println("New products entered.");
    }

    public Product getProduct(String name, int quantity) {
        //TODO: check for negative quantity

        Product toReturn;
        for (int i = 0; i < this.products.length; i++) {
            // find product with same name
            if (this.products[i].getName().equals(name)) {
                //the product is selling by piece
                if (this.products[i] instanceof ProductByAmount) {
                    int productAmount = ((ProductByAmount) this.products[i]).getProductAmount();
                    //the client want more than the available
                    if (quantity > productAmount) {
                        System.out.println("You get only " + productAmount + " pieces of " + name);
                        toReturn = this.products[i];
                        this.products[i] = null;
                        return toReturn;

                    } else {
                        toReturn = new ProductByAmount(name, this.products[i].getPrice(), quantity);
                        ((ProductByAmount) this.products[i]).removePieces(quantity);

                        //remove empty product
                        if (((ProductByAmount) this.products[i]).getProductAmount() == 0) {
                            this.products[i] = null;
                        }

                        return toReturn;
                    }

                } else {
                    // not sold by weight exception
                }
            }
        }

        throw new UnsupportedOperationException("No such product!");
    }

    public Product getProduct(String name, double kilograms) {
        //TODO: check for negative kilograms

        Product toReturn;
        for (int i = 0; i < this.products.length; i++) {
            // find product with same name
            if (this.products[i].getName().equals(name)) {

                //the product is selling by piece
                if (this.products[i] instanceof ProductByKilogram) {
                    double productKilograms = ((ProductByKilogram) this.products[i]).getKilograms();

                    //the client want more than the available
                    if (kilograms > productKilograms) {
                        System.out.println("You get only " + productKilograms + " kilograms of " + name);
                        toReturn = this.products[i];
                        this.products[i] = null;
                        return toReturn;

                    } else {
                        toReturn = new ProductByKilogram(name, this.products[i].getPrice(), kilograms);
                        ((ProductByKilogram) this.products[i]).cutFromTheProduct(kilograms);

                        //remove empty product
                        if (((ProductByKilogram) this.products[i]).getKilograms() == 0) {
                            this.products[i] = null;
                        }
                        return toReturn;
                    }

                } else {
                    // not sold by weight exception
                }
            }
        }

        throw new UnsupportedOperationException("No such product!");
    }

    public void payForProducts(Product... products){
        // TODO: ....
    }
}
