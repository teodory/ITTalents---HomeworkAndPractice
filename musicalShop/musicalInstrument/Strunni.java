package musicalInstrument;

/**
 * Created by Parapanov on 31/07/2016.
 */
public abstract class Strunni extends Instrument{

    public Strunni(String name, double price, int amount) {
        super(name, price, amount, InstrumentsType.STUNNI);
    }



}
