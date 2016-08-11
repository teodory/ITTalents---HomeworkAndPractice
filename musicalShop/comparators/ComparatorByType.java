package comparators;

import musicalInstrument.Instrument;

import java.util.Comparator;

/**
 * Created by Parapanov on 31/07/2016.
 */
public class ComparatorByType implements Comparator<Instrument> {

    @Override
    public int compare(Instrument o1, Instrument o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
