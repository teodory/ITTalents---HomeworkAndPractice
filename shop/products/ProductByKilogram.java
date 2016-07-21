package products;

/**
 * Created by Parapanov on 20/07/2016.
 */
public class ProductByKilogram extends Product {

    private double kilograms;

    public ProductByKilogram(String name, double price, double kilograms) {
        super(name, price);
        this.setKilograms(kilograms);
    }

    private void setKilograms(double kilograms) {
        if(kilograms <= 0){
            throw new IllegalArgumentException("Inavlid product kilograms.");
        }
        this.kilograms = kilograms;
    }

    public double getKilograms() {
        return kilograms;
    }

    public void cutFromTheProduct(double kilograms){
        this.kilograms -= kilograms;
    }
}
