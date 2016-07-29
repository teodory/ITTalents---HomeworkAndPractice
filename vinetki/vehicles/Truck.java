package vehicles;

import vinetki.TruckVinetka;

/**
 * Created by Parapanov on 28/07/2016.
 */
public class Truck extends Vehicle {

    private Truck(String model, int year, TruckVinetka vinetka) {
        super(model, year, vinetka);
    }

    public Truck(String model, int year) {
        super(model, year);
    }
}
