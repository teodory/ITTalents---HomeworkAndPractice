package vinetki;

import contracts.ITruckVinetka;

/**
 * Created by Parapanov on 28/07/2016.
 */
public class TruckVinetka extends Vinetka implements ITruckVinetka {

    private static final String TRUCK_VINETKA_COLOR = "Yellow";
    private static final int TRUCK_VINETKA_PRICE = 7;
    private static final int TIME_TO_SET = 10;

    public TruckVinetka(VinetkaPeriod period) {
        super(TRUCK_VINETKA_COLOR, period);
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
                price += TRUCK_VINETKA_PRICE;
                break;
            case MONTH:
                price += (TRUCK_VINETKA_PRICE * 7) * 10;
                break;
            case YEAR:
                price += ((TRUCK_VINETKA_PRICE * 7) * 10) * 6;
                break;
        }

        return price;
    }
}
