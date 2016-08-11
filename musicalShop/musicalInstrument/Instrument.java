package musicalInstrument;

/**
 * Created by Parapanov on 31/07/2016.
 */
public abstract class Instrument implements Cloneable{

    enum InstrumentsType {STUNNI, UDARNI};

    private String name;
    private double price;
    private int amount;
    private String type;

    public Instrument(String name, double price, int amount, InstrumentsType type) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.type = type.toString();
    }

    public String getName() {
        return name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name + " " + type + " "+ amount + " " + price;
    }


    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Instrument)obj).getName());
    }
}
