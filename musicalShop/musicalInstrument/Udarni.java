package musicalInstrument;

/**
 * Created by Parapanov on 31/07/2016.
 */
public abstract class Udarni extends Instrument{

    public Udarni(String name, double price, int amount) {
        super(name, price, amount, InstrumentsType.UDARNI);
    }



}
