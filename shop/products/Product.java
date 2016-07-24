package products;

/**
 * Created by Parapanov on 20/07/2016.
 */
public abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract double getCount();

    public abstract void removeAmount(double amount);

    public abstract void returnProduct(double cout);

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("Name: " + this.name)
                .append(System.lineSeparator())
                .append("Price: " + this.price);

        return out.toString();
    }
}
