package vinetki;

import contracts.IBusVinetka;

/**
 * Created by Parapanov on 28/07/2016.
 */
public class BusVinetka extends Vinetka implements IBusVinetka {


    private static final String BUS_VINETKA_COLOR = "Red";
    private static final int BUS_VINETKA_PRICE = 9;
    private static final int TIME_TO_SET = 20;

    public BusVinetka(VinetkaPeriod period) {
        super(BUS_VINETKA_COLOR, period);
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
                price += BUS_VINETKA_PRICE;
                break;
            case MONTH:
                price += (BUS_VINETKA_PRICE * 7) * 10;
                break;
            case YEAR:
                price += ((BUS_VINETKA_PRICE * 7) * 10) * 6;
                break;
        }

        return price;
    }
}
