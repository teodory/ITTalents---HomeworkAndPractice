package Dealers;

import ShopingCenters.Wharehouse;

import java.util.Arrays;

/**
 * Created by Parapanov on 19/07/2016.
 */
public abstract class Dealer {

    private String name;
    private String address;
    private double caliptal;
    private int selledProductsCount;
    private double totalPayedTaxes;

    public Dealer(String name, String address, double caliptal) {
        this.name = name;
        this.address = address;
        this.caliptal = caliptal;
        this.selledProductsCount = 0;
        this.totalPayedTaxes = 0;
    }

    public double getCaliptal() {
        return caliptal;
    }

    protected void setCaliptal(double caliptal) {
        this.caliptal = caliptal;
    }

    public int getSelledProductsCount() {
        return selledProductsCount;
    }

    public void setSelledProductsCount(int selledProductsCount) {
        this.selledProductsCount = selledProductsCount;
    }

    public double getTotalPayedTaxes() {
        return totalPayedTaxes;
    }

    protected void addTotalPayedTaxes(double totalPayedTaxes) {
        this.totalPayedTaxes += totalPayedTaxes;
    }

    public abstract void startTradingActivity();

    public void payOrder(double totalCoast) {
        this.caliptal -= totalCoast;
    }

    public void printOrder(Product[] products) {

        products = Wharehouse.clearEmptyElements(products);
        Arrays.sort(products);

        for (int i = 0; i < products.length; i++) {
            if (products != null) {
                System.out.println(products[i]);
            }
        }
    }

    protected abstract void payTaxes();

}
