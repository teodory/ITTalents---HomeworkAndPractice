package Dealers;

import java.util.Random;

/**
 * Created by Parapanov on 20/07/2016.
 */
public class RandomDetails {

    private static String[] names = {"Gosho", "Pesho", "Misho", "Lili", "Anabel", "Tim", "Patrick", "Kichka"};
    private static String[] addresses = {"Sofia", "Plovdiv", "Karlovo", "Varna", "Ruse", "Turnovo"};
    private static String workingTime = "9:00 - 20:00";
    private static String[] productsNames = {"Vafla", "Pasta", "Banana", "Potato", "Zippo", "Mineralwasser"};


    private static Random random = new Random();

    public static String getName(){
        return names[random.nextInt(names.length)];
    }

    public static String getAddres(){
        return addresses[random.nextInt(addresses.length)];
    }

    public static String getWorkingTime(){
        return workingTime;
    }

    public static String getPtoductName(){
        return productsNames[random.nextInt(productsNames.length)];
    }

    public static double getProductPrice(){
        return (double)random.nextInt(11)+5;
    }

}
