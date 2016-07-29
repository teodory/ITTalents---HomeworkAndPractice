package vehicles;

import exceptions.NoVinetkaException;
import vinetki.Vinetka;

/**
 * Created by Parapanov on 28/07/2016.
 */
public abstract class Vehicle {

    private String model;
    private int year;
    private Vinetka vinetka;

    public Vehicle(String model, int year, Vinetka vinetka) {
        this(model, year);
        this.vinetka = vinetka;
    }

    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public Vinetka getVinetka() throws NoVinetkaException {
        if(vinetka == null){
            throw new NoVinetkaException("Car without vinetka");
        }
       return this.vinetka;
    }

    public void setVinetka(Vinetka vinetka) {
        this.vinetka = vinetka;
        vinetka.setOnWindow(); // returns some seconds
    }

    @Override
    public String toString() {
        return this.model + " " + this.year;
    }
}
