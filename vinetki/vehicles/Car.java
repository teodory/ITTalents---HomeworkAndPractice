package vehicles;

import vinetki.CarVinetka;

/**
 * Created by Parapanov on 28/07/2016.
 */
public class Car extends Vehicle {

    public Car(String model, int year, CarVinetka vinetka) {
        super(model, year, vinetka);
    }

    public Car(String model, int year)
    {
        super(model, year);
    }
}
