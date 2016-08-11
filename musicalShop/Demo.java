import musicalInstrument.Barabanche;
import musicalInstrument.Kitara;
import shop.Shop;

/**
 * Created by Parapanov on 31/07/2016.
 */
public class Demo {

    public static void main(String[] args) {

        Kitara kitara = new Kitara("Kitara", 100, 0);
        Barabanche barabanche = new Barabanche("Barabanche", 90, 0);
        Kitara kitara1 = new Kitara("dedo kitara", 50, 0);


        Shop shop = new Shop();

        shop.add(kitara, 15);
        shop.add(barabanche, 2);
        shop.add(kitara1, 1);

        System.out.println();
        shop.sell("Kitara", 2);
        shop.sell("Kitara", 5);
        shop.sell("Barabanche", 1);

//        shop.sort(BY_NAME);
//        System.out.println("================================");
//        shop.sort(BY_TYPE);
//        System.out.println("================================");
//        shop.sort(BY_PRICE_ASCENDING);
//        System.out.println("================================");
//        shop.sort(BY_PRICE_DESCENDING);
        System.out.println("================================");
//        shop.showAvailable();

        shop.showSold();
        System.out.println(shop.getProfit());

        shop.printMostSold();
        shop.printLeastSold();
        shop.printMostSoldType();

        System.out.println();


    }

}
