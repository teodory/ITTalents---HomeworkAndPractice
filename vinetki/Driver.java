import contracts.IDriver;
import exceptions.NoVinetkaException;
import vehicles.Vehicle;
import vinetki.Vinetka;
import vinetki.VinetkaPeriod;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Parapanov on 28/07/2016.
 */
public class Driver implements IDriver {

    private String name;
    private List<Vehicle> vehicles;
    private double money;
    private GasStation gasStation;

    public Driver(String name, double money, GasStation gasStation) {
        this.name = name;
        this.money = money;
        this.gasStation = gasStation;
        this.vehicles = new ArrayList<>();
    }

    public int getVehiclesNumber() {
        return this.vehicles.size();
    }

    @Override
    public void buyVinetkiForAllVehicles(VinetkaPeriod period) {
        for (int i = 0; i < this.vehicles.size(); i++) {
            buyVinetkaForVehicle(i + 1, period);
        }
    }

    @Override
    public void buyVinetkaForVehicle(int number, VinetkaPeriod period) {
//        TODO if have valid vinetka

        int vehicleInd = number - 1;

        if (vehicleInd < 0 || vehicleInd >= vehicles.size()) {
            throw new UnsupportedOperationException("Invalid vehicle number");
        }

        try {

            if(vehicles.get(vehicleInd).getVinetka().getExpiryDate().compareTo(LocalDate.now()) >= 0){
                System.out.println("No need to buy vinetka");
                return;
            }

        } catch (NoVinetkaException e) {

        }

        Vinetka vinetka = gasStation.getVinetka(vehicles.get(vehicleInd), period, this);
        if (vinetka != null) {
            this.vehicles.get(vehicleInd).setVinetka(vinetka);

        }
    }

    @Override
    public void printExpiresVinetka(LocalDate localDate) {

    }

    @Override
    public boolean payPrice(double price) {
        if (money < price){
//            System.out.println("No money for vinetka");
            return false;
        }
        this.money -= price;
        return true;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void setGasStation(GasStation gasStation) {
        this.gasStation = gasStation;
    }

    public void printInfo(LocalDate localDate) {
        System.out.println("------ Driver: " + this.name + " ------");
        System.out.println("Total vehicles: " + this.vehicles.size());
        System.out.println("Vehicles without vinetka at " + localDate);
        for (int i = 0; i < this.vehicles.size(); i++) {
            try {

                if (vehicles.get(i).getVinetka().getExpiryDate().compareTo(localDate) < 0) {
                    System.out.print(vehicles.get(i) + ", ");
                }

            } catch (NullPointerException e) {

            } catch (NoVinetkaException e) {

            }
        }
        System.out.println();
        System.out.printf("Driver money: %.2f%n", this.money);
        System.out.println();
    }
}
