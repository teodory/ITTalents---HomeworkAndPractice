package lesson27.shop.comparators;

import lesson27.musicalInstruments.MusicalInstrument;

import java.util.Comparator;

/**
 * Created by Parapanov on 10/08/2016.
 */
public class InstrumentsByPriceAscendingComparator implements Comparator<MusicalInstrument> {

    @Override
    public int compare(MusicalInstrument o1, MusicalInstrument o2) {
        if(o1.getPrice() > o2.getPrice()){
            return 1;
        }
        if(o1.getPrice() < o2.getPrice()){
            return -1;
        }
        return 0;
    }
}
