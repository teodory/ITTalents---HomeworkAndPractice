package products;

/**
 * Created by Parapanov on 20/07/2016.
 */
public class ProductByAmount extends Product {

    private int productAmount;

    public ProductByAmount(String name, double price, int productAmount) {
        super(name, price);
        this.setProductAmount(productAmount);
    }

    private void setProductAmount(int productAmount) {
        if(productAmount <= 0){
            throw new IllegalArgumentException("Invalid Product amount.");
        }
        this.productAmount = productAmount;
    }

    @Override
    public void removeAmount(double amount){
        this.productAmount -= amount;
    }

    public double getCount() {
        return productAmount;
    }

    @Override
    public void returnProduct(double count) {
        this.productAmount += count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( super.toString());
        sb.append(System.lineSeparator())
                .append("Amount: " + this.productAmount);

        return sb.toString();
    }
}
