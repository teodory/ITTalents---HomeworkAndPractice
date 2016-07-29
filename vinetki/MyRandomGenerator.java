import vehicles.Bus;
import vehicles.Car;
import vehicles.Truck;
import vehicles.Vehicle;
import vinetki.*;

import java.util.Random;

import static vinetki.VinetkaPeriod.*;

/**
 * Created by Parapanov on 28/07/2016.
 */
public class MyRandomGenerator {
    static Random random = new Random();
    static String[] names = { "Ivan", "Petkan", "Dragan", "Simo", "Sasho", "Ana", "Lili", "Kichka"};
    static int[] moneys = {531464, 7864654, 4654, 78587, 1111111, 68465464,6545,654,123,987,125,4};
    static String[] carModels = {"BMW", "Audi", "Mercedes", "Nissan", "Toyota", "Honda", "Opel"};


    static Vinetka getVinetka(){

        int type = random.nextInt(3);
        switch (type){
            case 0 :
                return new CarVinetka(getPeriod());
            case 1 :
                return new TruckVinetka(getPeriod());
            case 2 :
                return new BusVinetka(getPeriod());
            default:
                throw new IllegalArgumentException();
        }
    }

    static VinetkaPeriod getPeriod(){
        int period = random.nextInt(3);
        switch (period){
            case 0:
                return DAY;
            case 1:
                return MONTH;
            case 2:
                return YEAR;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static String getName() {
        return names[random.nextInt(names.length)];
    }

    public static double getMoney() {
        return moneys[random.nextInt(moneys.length)];
    }

    public static Vehicle getVehicle() {
        switch (random.nextInt(3)){
            case 0:
                return new Car(carModels[random.nextInt(carModels.length)], 2012);
            case 1:
                return new Truck(carModels[random.nextInt(carModels.length)], 2012);
            case 2:
                return new Bus(carModels[random.nextInt(carModels.length)], 2012);
        }
        throw new IllegalArgumentException();
    }
}
