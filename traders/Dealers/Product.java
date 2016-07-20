package Dealers;

/**
 * Created by Parapanov on 20/07/2016.
 */
public class Product implements Comparable<Product>{

    private String name;
    private double price;

    public Product() {
        this.name = RandomDetails.getPtoductName();
        this.price = RandomDetails.getProductPrice();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product other) {

        if(this.price > other.price){
            return 1;
        }
        if (this.price < other.price){
            return -1;
        }

        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        out.append("Name: " + this.name)
                .append(System.lineSeparator())
                .append("Price: " + this.price + "lv.");

        return out.toString();
    }
}
