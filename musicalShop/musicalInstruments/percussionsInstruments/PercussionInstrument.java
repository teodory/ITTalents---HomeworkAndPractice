package lesson27.musicalInstruments.percussionsInstruments;

import lesson27.musicalInstruments.MusicalInstrument;

/**
 * Created by Parapanov on 10/08/2016.
 */
public abstract class PercussionInstrument extends MusicalInstrument {

    public static final String TYPE = "Percussion Instrument";


    public PercussionInstrument(String name, double price, int amount) {
        super(name, price, amount, TYPE);
    }
}
