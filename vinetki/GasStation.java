import contracts.IBusVinetka;
import contracts.ICarVinetka;
import contracts.ITruckVinetka;
import vehicles.Bus;
import vehicles.Car;
import vehicles.Truck;
import vehicles.Vehicle;
import vinetki.Vinetka;
import vinetki.VinetkaPeriod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Parapanov on 28/07/2016.
 */
public class GasStation {

    private double gain;
    private List<Vinetka> vinetkas;

    public GasStation() {
        this.gain = 0;
        this.generateVinetki();
    }

    private void generateVinetki() {
        vinetkas = new ArrayList<>(10000);
        for (int i = 0; i < 1000; i++) { //TODO make 10000
            this.vinetkas.add(MyRandomGenerator.getVinetka());
        }

        Collections.sort(this.vinetkas);
    }

    public Vinetka getVinetka(Vehicle vehicle, VinetkaPeriod period, Driver buyer) {

        Vinetka vinetkaToGO = null;
        int vinetkaIndex = -1;
        for (int i = 0; i < this.vinetkas.size(); i++) {
//            TODO refactor here
            if (vinetkas.get(i).getPeriod().equals(period)) {

                if (vehicle instanceof Car) {
                    if (vinetkas.get(i) instanceof ICarVinetka) {
                        vinetkaToGO = vinetkas.get(i);
                        vinetkaIndex = i;
                        break;
                    }
                }
                if (vehicle instanceof Truck) {
                    if (vinetkas.get(i) instanceof ITruckVinetka) {
                        vinetkaToGO = vinetkas.get(i);
                        vinetkaIndex = i;
                        break;
                    }
                }
                if (vehicle instanceof Bus) {
                    if (vinetkas.get(i) instanceof IBusVinetka) {
                        vinetkaToGO = vinetkas.get(i);
                        vinetkaIndex = i;
                        break;
                    }
                }
            }
        }

        if (vinetkaToGO != null) {
            if (buyer.payPrice(vinetkaToGO.getPrice())) {

                this.gain += vinetkaToGO.getPrice();
                vinetkas.remove(vinetkaIndex);
            }

        } else {
            System.out.println("No vinetka bro");
        }

        return vinetkaToGO;
    }

    public void printAllVinetkaInStock() {
        for (int i = 0; i < vinetkas.size(); i++) {
            System.out.println(vinetkas.get(i));
        }
    }
}
