package randomGenerator;

import java.util.Random;

/**
 * Created by Parapanov on 30/07/2016.
 */
public class MyRandom {

    public static Random random = new Random();
    static String[] names = { "Ivan", "Petkan", "Dragan", "Simo", "Sasho", "Ana", "Lili", "Kichka"};
    static int[] salaries = {1000, 2000, 3000, 4000, 1500, 900, 700, 1800, 1200};

    public static String getName(){
        return names[random.nextInt(names.length)];
    }
    public static int getSalary(){
        return salaries[random.nextInt(salaries.length)];
    }

}