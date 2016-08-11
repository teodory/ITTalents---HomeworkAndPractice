package lesson27;

import lesson27.musicalInstruments.MusicalInstrument;
import lesson27.musicalInstruments.brassInstruments.Trombone;
import lesson27.musicalInstruments.brassInstruments.Trumpet;
import lesson27.musicalInstruments.percussionsInstruments.Drum;
import lesson27.musicalInstruments.percussionsInstruments.Tambourine;
import lesson27.musicalInstruments.stringedInstruments.Guitar;
import lesson27.musicalInstruments.stringedInstruments.Viola;
import lesson27.musicalInstruments.stringedInstruments.Violin;
import lesson27.shop.Shop;
import lesson27.shop.exceptions.NoSuchMusicalInstrumentException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Parapanov on 10/08/2016.
 */
public class DemoShop {

    public static void main(String[] args) throws NoSuchMusicalInstrumentException {
        InstrumentsSupplier supplier = new InstrumentsSupplier();
        Shop shop = new Shop("Basi Shopa", 200, supplier);

        MusicalInstrument[] musicalInstruments = getInstruments();
        shop.loadInstruments(musicalInstruments);

        shop.addInstrument("Trombone", 5);
        shop.addInstrument("Trumpet", 0);
        shop.addInstrument("Drum", 6);
        shop.addInstrument("Tambourine", 3);
        shop.addInstrument("Guitar", 2);
        shop.addInstrument("Viola", 9);
        shop.addInstrument("Violin", 6);

        shop.printInstrumentsSortedByName();

        shop.sellInstrument("Trumpet", 3);

        shop.sellInstrument("Violin", 1);
        shop.sellInstrument("Violin", 1);
        shop.sellInstrument("Viola", 1);
        shop.sellInstrument("Drum", 6);

        shop.printInstrumentsSortedByName();


//        shop.printInstrumentsSortedByType();
//        shop.printInstrumentsSortedByName();
//        shop.printInstrumentsSortedByPrice(DESCENDING);
//        shop.printAvailableInstruments();
        shop.printSoldInstrumentsByAmount();
        shop.printSoldInstrumentsTotalCash();
        shop.printMostSoldInstrument();
        shop.printMostUnsoldInstrument();
        shop.printMostSoldTypeInstruments();
        shop.printMostIncomeType();

        shop.printAvailableInstruments();
    }

    private static MusicalInstrument[] getInstruments() {

        List<MusicalInstrument> instruments = new ArrayList<>();
        instruments.add(new Trombone("Trombone", 43.50, 0));
        instruments.add(new Trumpet("Trumpet", 24.00, 0));
        instruments.add(new Drum("Drum", 55, 0));
        instruments.add(new Tambourine("Tambourine", 22.50, 0));
        instruments.add(new Guitar("Guitar", 99.33, 0));
        instruments.add(new Viola("Viola", 120, 0));
        instruments.add(new Violin("Violin", 100, 0));

        return instruments.toArray(new MusicalInstrument[instruments.size()]);
    }
}
