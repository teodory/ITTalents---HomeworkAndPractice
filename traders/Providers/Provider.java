package Providers;

import Dealers.Dealer;
import Dealers.Product;

/**
 * Created by Parapanov on 19/07/2016.
 */
public abstract class Provider {

    private String name;
    private String address;
    private String workingTime;

    public Provider(String name, String address, String workingTime) {
        this.setName(name);
        this.setAddress(address);
        this.setWorkingTime(workingTime);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    private void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    public Product[] orderProducts(double money, Dealer ambulateTrader){
        Product[] products = new Product[(int)money/5];
        int freeInd = 0;
        double totalCoast = 0;

        while (totalCoast < money){
            Product current = new Product();
            if(totalCoast + 5 > money){
                break;
            }
            products[freeInd++] = current;
            totalCoast += current.getPrice();
        }

        totalCoast -= getDiscount(totalCoast);
        ambulateTrader.payOrder(totalCoast);

        return products;
    }

    protected abstract double getDiscount(double totalCoast);
}
