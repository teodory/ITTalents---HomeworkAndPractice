package lesson27.shop.comparators;

import lesson27.musicalInstruments.MusicalInstrument;

import java.util.Comparator;

/**
 * Created by Parapanov on 10/08/2016.
 */
public class InstrumentsByNameComparator implements Comparator<MusicalInstrument>{

    @Override
    public int compare(MusicalInstrument o1, MusicalInstrument o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
