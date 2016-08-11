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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Parapanov on 10/08/2016.
 */
public class InstrumentsSupplier {

    private Map<MusicalInstrument, Integer> instruments;

    public InstrumentsSupplier() {
        this.generateInstruments();
    }

    private void generateInstruments(){
        this.instruments = new HashMap<>();
        this.instruments.put(new Trombone("Trombone", 43.50, 0), 1000);
        this.instruments.put(new Trumpet("Trumpet", 24.00, 0), 2000);
        this.instruments.put(new Drum("Drum", 55, 0), 1500);
        this.instruments.put(new Tambourine("Tambourine", 22.50, 0), 3000);
        this.instruments.put(new Guitar("Guitar", 99.33, 0), 2500);
        this.instruments.put(new Viola("Viola", 120, 0), 2000);
        this.instruments.put(new Violin("Violin", 100, 0), 1200);
    }

    public int getTimeForDeliver(String instrumentName, int amount) throws NoSuchMusicalInstrumentException {
        MusicalInstrument wantedInstrument = null;

        wantedInstrument = getMusicalInstrument(instrumentName);

        if(wantedInstrument != null){
            return this.instruments.get(wantedInstrument) * amount;

        }

        throw new NoSuchMusicalInstrumentException("No such Musical Instrument.");
    }

    private MusicalInstrument getMusicalInstrument(String instrumentName) {

        for (MusicalInstrument instrument : this.instruments.keySet()) {
            if(instrument.getName().equals(instrumentName)){
                 return  instrument;
            }
        }
        return null;
    }

    public void deliverInstrument(String name, Shop shop) throws NoSuchMusicalInstrumentException {
        MusicalInstrument wantedInstrument = getMusicalInstrument(name);
        if(wantedInstrument != null){
            try {
                Thread.sleep(this.instruments.get(wantedInstrument));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        shop.addInstrument(wantedInstrument.getName(), 5);
    }

    public void supplyMissingInstruments(List<String> names, Shop shop) throws NoSuchMusicalInstrumentException {
        for (String name : names) {
            MusicalInstrument current = getMusicalInstrument(name); //useless
            shop.addInstrument(current.getName(), 5);
        }
    }
}
