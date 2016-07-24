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

    public void removeAmount(double kilograms){
        this.kilograms -= kilograms;
    }

    @Override
    public void returnProduct(double count) {
        this.kilograms += count;
    }

    @Override
    public double getCount() {
        return kilograms;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( super.toString());
        sb.append(System.lineSeparator())
                .append("Kilograms: " + this.kilograms);

        return sb.toString();
    }
}
