import vehicles.Vehicle;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Parapanov on 25/07/2016.
 */
public class Demo {

    public static void main(String[] args) {

//          1.
        GasStation gasStation = new GasStation();
//          1.1
//        gasStation.printAllVinetkaInStock();

//          2.
        List<Driver> drivers = new ArrayList<>();
        addDrivers(20, drivers, gasStation);

//        3.
        List<Vehicle> vehicles = new ArrayList<>();
        addVehicle(200, vehicles);
        addVehiclesToDrivers(drivers, vehicles);

//        4.
        buyVinetka(drivers);

//        5.
        getDriversInfo(drivers, 2016, 8, 2);

//        6.
//        gasStation.printAllVinetkaInStock();

        System.out.println();
    }

    private static void getDriversInfo(List<Driver> drivers, int year, int month, int day) {
        LocalDate localDate = null;
        try {
            localDate = LocalDate.of(year, month, day);
        } catch (DateTimeException dte) {
            System.out.println("Invalid date.");
        }

        for (int i = 0; i < drivers.size(); i++) {
            drivers.get(i).printInfo(localDate);
        }
    }

    private static void buyVinetka(List<Driver> drivers) {
        for (int i = 0; i < drivers.size(); i++) {
            if (i % 3 == 0) {
                buyVinetkaForRandomVehicle(drivers.get(i));
                continue;
            }
            drivers.get(i).buyVinetkiForAllVehicles(MyRandomGenerator.getPeriod());
        }
    }

    private static void buyVinetkaForRandomVehicle(Driver driver) {
        for (int i = 0; i < 5; i++) {
            int vechicleNumber = MyRandomGenerator.random.nextInt(driver.getVehiclesNumber()) + 1;
            driver.buyVinetkaForVehicle(vechicleNumber, MyRandomGenerator.getPeriod());
        }
    }


    private static void addVehiclesToDrivers(List<Driver> drivers, List<Vehicle> vehicles) {

        for (int i = 0; i < drivers.size(); i++) {

            for (int j = 0; j < 10; j++) {
                int nextVihicleInd = MyRandomGenerator.random.nextInt(vehicles.size());
                drivers.get(i).addVehicle(vehicles.get(nextVihicleInd));
                vehicles.remove(nextVihicleInd);
            }
        }
    }

    private static void addVehicle(int count, List<Vehicle> vehicles) {
        for (int i = 0; i < count; i++) {
            vehicles.add(MyRandomGenerator.getVehicle());
        }
    }

    private static void addDrivers(int count, List<Driver> drivers, GasStation gasStation) {
        for (int i = 0; i < count; i++) {
            Driver driver = new Driver(MyRandomGenerator.getName(), MyRandomGenerator.getMoney(), gasStation);
            driver.setGasStation(gasStation);
            drivers.add(driver);
        }
    }
}
