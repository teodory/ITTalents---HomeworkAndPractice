package comparators;

import musicalInstrument.Instrument;

import java.util.Comparator;

/**
 * Created by Parapanov on 31/07/2016.
 */
public class ComparatorByPriceAZ implements Comparator<Instrument> {

    @Override
    public int compare(Instrument o1, Instrument o2) {

        if(o1.getPrice() > o2.getPrice()){
            return 1;
        }
        if(o1.getPrice() < o2.getPrice()){
            return -1;
        }

        return 0;
    }
}
