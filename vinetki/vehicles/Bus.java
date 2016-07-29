package vehicles;

import vinetki.BusVinetka;

/**
 * Created by Parapanov on 28/07/2016.
 */
public class Bus extends Vehicle {


    private Bus(String model, int year, BusVinetka vinetka) {
        super(model, year, vinetka);
    }

    public Bus(String model, int year) {
        super(model, year);
    }
}
