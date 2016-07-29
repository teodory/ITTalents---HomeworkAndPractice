package vinetki;

import contracts.ICarVinetka;

/**
 * Created by Parapanov on 28/07/2016.
 */
public class CarVinetka extends Vinetka implements ICarVinetka {

    private static final String CAR_VINETKA_COLOR = "Green";
    private static final int CAR_VINETKA_PRICE = 5;
    private static final int TIME_TO_SET = 5;

    public CarVinetka(VinetkaPeriod period) {
        super(CAR_VINETKA_COLOR, period);
    }

    @Override
    public int setOnWindow() {
        return TIME_TO_SET;
    }

    @Override
    public double getPrice() {
        double price = 0;
        switch (getPeriod()){
            case DAY:
                price += CAR_VINETKA_PRICE;
                break;
            case MONTH:
                price += (CAR_VINETKA_PRICE * 7) * 10;
                break;
            case YEAR:
                price += ((CAR_VINETKA_PRICE * 7) * 10) * 6;
            break;
        }

        return price;
    }
}
