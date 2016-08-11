package lesson27.musicalInstruments.stringedInstruments;

import lesson27.musicalInstruments.MusicalInstrument;

/**
 * Created by Parapanov on 10/08/2016.
 */
public abstract class StringedInstrument extends MusicalInstrument {

    public static final String TYPE = "Stringed Instrument";

    public StringedInstrument(String name, double price, int amount) {
        super(name, price, amount, TYPE);
    }
}
