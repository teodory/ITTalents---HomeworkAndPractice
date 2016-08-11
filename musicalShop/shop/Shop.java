package shop;

import comparators.*;
import musicalInstrument.Instrument;

import java.util.*;

/**
 * Created by Parapanov on 31/07/2016.
 */
public class Shop {

    public enum sortingType{BY_NAME, BY_TYPE, BY_PRICE_ASCENDING, BY_PRICE_DESCENDING}

    private String name;
    private List<Instrument> instruments;
    private List<Instrument> soldInstruments;

    private double cash;

    public Shop() {
        this.name = "Pri Bat Kiro Jitzata";
        this.cash = 0;
        this.instruments = new ArrayList<>();
        soldInstruments = new ArrayList<>();
    }

    public void add(Instrument instrument, int amount){
        for (int i = 0; i < this.instruments.size(); i++) {
            if(instruments.get(i).getName().equals(instrument.getName())){
                instruments.get(i).addAmount(amount);
                return;
            }
        }

        instrument.addAmount(amount);
        this.instruments.add(instrument);
    }

    public void sell(String name, int amount){

        for (Instrument instrument : this.instruments) {
            if(instrument.getName().equals(name)){
                if(instrument.getAmount() < amount){
                    System.out.println("Fuck you");
                    return;
                }

                addSoldProduct(amount, instrument);

                instrument.addAmount(-amount);

                this.cash += instrument.getPrice() * amount;
                System.out.println("There you go gay.");
                return;
            }
        }

        System.out.println("Nqmame go toq instrument gay.");
    }

    private void addSoldProduct(int amount, Instrument instrument) {

        Instrument cloned = null;
        try {
            cloned = (Instrument) instrument.clone();

        } catch (CloneNotSupportedException e) {
            System.out.println("PROBLEM Brat");
        }

        int ind = soldInstruments.indexOf(instrument);

        if(ind < 0){
            cloned.setAmount(amount);
            soldInstruments.add(cloned);
        }else {
            soldInstruments.get(ind).addAmount(amount);
        }
    }

    public void sort(sortingType sortingType){
        switch (sortingType){
            case BY_NAME:
                Collections.sort(this.instruments, new ComparatorByName());
                print();
                break;

            case BY_TYPE:
                Collections.sort(this.instruments, new ComparatorByType());
                print();
                break;
            case BY_PRICE_ASCENDING:
                Collections.sort(this.instruments, new ComparatorByPriceAZ());
                print();
                break;

            case BY_PRICE_DESCENDING:
                Collections.sort(this.instruments, new ComparatorByPriceZA());
                print();
                break;

        }

    }

    public void showAvailable(){
        for (Instrument instrument : instruments) {
            if(instrument.getAmount() > 0){
                System.out.println(instrument);
            }
        }
    }

    public void showSold(){
        Collections.sort(soldInstruments, new ComparatorByAmount());
        printSold();
    }

    public double getProfit(){
        double sum = 0;
        for (Instrument soldInstrument : soldInstruments) {
            sum += soldInstrument.getAmount() * soldInstrument.getPrice();
        }

        return sum;
    }

    public void printMostSold(){
        Instrument instrument = null;
        int amount = 0;
        for (Instrument soldInstrument : soldInstruments) {
            if(amount < soldInstrument.getAmount()){
                amount = soldInstrument.getAmount();
                instrument = soldInstrument;
            }
        }

        if(instrument != null) {
            System.out.println(instrument);
        }else {
            System.out.println("da go duhash");
        }
    }

    public void printLeastSold(){
        Instrument instrument = null;
        int amount = Integer.MAX_VALUE;

        for (Instrument soldInstrument : soldInstruments) {
            if(amount > soldInstrument.getAmount()){
                amount = soldInstrument.getAmount();
                instrument = soldInstrument;
            }
        }

        if(instrument != null) {
            System.out.println(instrument);
        }else {
            System.out.println("da go duhash");
        }
    }

    public void printMostSoldType(){
        Map<String, Integer> soldByType = new HashMap<>();

        for (Instrument soldInstrument : soldInstruments) {

            if(!soldByType.containsKey(soldInstrument.getType())){

                soldByType.put(soldInstrument.getType(), 0);
            }

            int amount = soldByType.get(soldInstrument.getType()) + soldInstrument.getAmount();
            soldByType.put(soldInstrument.getType(), amount);
        }

//        Map.Entry<String, Integer> s = soldByType.entrySet()
//                .stream().reduce()

//        System.out.println(s.getKey());

    }

    private void printSold() {

        for (Instrument instrument : soldInstruments) {
            System.out.println(instrument);
        }

    }

    private void print() {

        for (Instrument instrument : instruments) {
            System.out.println(instrument);
        }

    }

}
