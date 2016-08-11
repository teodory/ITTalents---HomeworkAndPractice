package lesson27.musicalInstruments.brassInstruments;

import lesson27.musicalInstruments.MusicalInstrument;

/**
 * Created by Parapanov on 10/08/2016.
 */
public abstract class BrassInstrument extends MusicalInstrument {

    public static final String TYPE = "Brass Instrument";


    public BrassInstrument(String name, double price, int amount) {
        super(name, price, amount, TYPE);
    }
}
