package vinetki;

import contracts.IVinetka;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by Parapanov on 28/07/2016.
 */
public abstract class Vinetka implements IVinetka, Comparable<Vinetka> {

    private LocalDate dateOfCreation;
    private String color;
    private Period term;
    private VinetkaPeriod period;

    public Vinetka(String color, VinetkaPeriod period) {
        this.dateOfCreation = LocalDate.now();
        this.color = color;
        this.period = period;
        this.term = MyPeriodGenerator.getPeriod(period);
    }

    public VinetkaPeriod getPeriod() {
        return period;
    }

    @Override
    public int compareTo(Vinetka o) {
        if(this.getPrice() > o.getPrice()){
            return 1;
        }
        if(this.getPrice() < o.getPrice()){
            return  -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f - %s",
                this.getClass().getSimpleName(),
                this.getPrice(),
                this.color);
    }

    public LocalDate getExpiryDate(){
        return this.dateOfCreation.plus(term);
    }

}
