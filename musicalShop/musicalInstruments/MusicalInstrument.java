package lesson27.musicalInstruments;

/**
 * Created by Parapanov on 10/08/2016.
 */
public abstract class MusicalInstrument implements Cloneable {

    private String name;
    private double price;
    private int amount;
    private String type;

    public MusicalInstrument(String name, double price, int amount, String type) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public double getPrice(){
        return this.price;
    }

    public void reduceAmount(int amount){
        this.amount -= amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Name: " + this.name +
                " | Price: " + this.price +
                " | Type: " + this.type +
                " | Amount: " + this.amount;
    }

    @Override
    public MusicalInstrument clone() throws CloneNotSupportedException {
        return (MusicalInstrument) super.clone();
    }

}
