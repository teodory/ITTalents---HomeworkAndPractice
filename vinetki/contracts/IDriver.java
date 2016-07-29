package contracts;

import vehicles.Vehicle;
import vinetki.VinetkaPeriod;

import java.time.LocalDate;

/**
 * Created by Parapanov on 28/07/2016.
 */
public interface IDriver {

    void buyVinetkiForAllVehicles(VinetkaPeriod period);
    void buyVinetkaForVehicle(int number, VinetkaPeriod period);
    void printExpiresVinetka(LocalDate localDate);
    boolean payPrice(double price);
    void addVehicle(Vehicle vehicle);
}
