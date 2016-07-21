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

    public int getProductAmount() {
        return productAmount;
    }

    public void removePieces(int amount){
        this.productAmount -= amount;
    }
}
