import Dealers.*;
import Providers.LargeProvider;
import Providers.Provider;
import Providers.SmallProvider;
import ShopingCenters.*;

import java.util.Random;

/**
 * Created by Parapanov on 19/07/2016.
 */
public class DemoTraders {

    static String[] names = {"Gosho", "Pesho", "Misho", "Lili", "Anabel", "Tim", "Patrick", "Kichka"};
    static String[] addresses = {"Sofia", "Plovdiv", "Karlovo", "Varna", "Ruse", "Turnovo"};
    static String workingTime = "9:00 - 20:00";


    public static void main(String[] args) {
        Provider[] providers = new Provider[10];
        fillProviders(providers);
        ShopingCenter[] shopingCenters = new ShopingCenter[20];
        fillShopingCenters(shopingCenters);

        AmbulateTrader ambulateTrader = new AmbulateTrader(RandomDetails.getName(), RandomDetails.getAddres(), 100);
        SoleTrader soleTrader = new SoleTrader(RandomDetails.getName(), RandomDetails.getAddres(), 500);
        ChainTrader chainTrader = new ChainTrader(RandomDetails.getName(), RandomDetails.getAddres(), 3000);

        boolean soleTraderHasProvider = false;
        ChainTradingCenter[] chainTradingCenters = new ChainTradingCenter[10];
        int chainCentersInd = 0;

        for (int i = 0; i < shopingCenters.length; i++) {
            if(shopingCenters[i] instanceof SoleShopingCenter && !soleTraderHasProvider){
                soleTrader.setShopingCenter((SoleShopingCenter) shopingCenters[i]);
                soleTraderHasProvider = true;
            }else if(shopingCenters[i] instanceof ChainTradingCenter){
                chainTradingCenters[chainCentersInd++] = (ChainTradingCenter) shopingCenters[i];
                if(chainCentersInd >= 10){
                    break;
                }
            }
        }

        chainTrader.setShopingCenters(chainTradingCenters);

        Dealer[] traders = new Dealer[3];
        traders[0] = ambulateTrader;
        traders[1] = soleTrader;
        traders[2] = chainTrader;

        startTradingActivity(traders);

        for (int i = 0; i < traders.length; i++) {
            System.out.println(traders[i].getCaliptal());
        }

        printMostSelled(traders);
        printBiggestPayedTaxes(traders);

        System.out.println();
    }

    private static void printBiggestPayedTaxes(Dealer[] traders) {
        double biggestTaxes = 0;

        for (int i = 0; i < traders.length; i++) {
            if(traders[i] instanceof AmbulateTrader){
                continue;
            }else if(biggestTaxes < traders[i].getTotalPayedTaxes()){
                biggestTaxes = traders[i].getTotalPayedTaxes();
            }
        }

        System.out.println("Biggest payed taxes: " + biggestTaxes);
    }

    private static void printMostSelled(Dealer[] traders) {
        int aumond = 0;
        for (int i = 0; i < traders.length; i++) {
            if (aumond < traders[i].getSelledProductsCount()){
                aumond = traders[i].getSelledProductsCount();
            }
        }

        System.out.println("Biggest product selling almond: " + aumond);
    }

    private static void startTradingActivity(Dealer[] traders) {
        for (int i = 0; i < traders.length; i++) {
            traders[i].startTradingActivity();
            System.out.println("-----------------------------------------");
        }
    }

    private static void fillShopingCenters(ShopingCenter[] shopingCenters) {
        for (int i = 0; i < shopingCenters.length; i++) {
            shopingCenters[i] = getShopintCenter();
        }
    }

    private static void fillProviders(Provider[] providers) {
        for (int i = 0; i < providers.length; i++) {
            providers[i] = getProvider();
        }
    }

    private static Provider getProvider() {
        Random random = new Random();
        String name = names[random.nextInt(names.length)];
        String address = addresses[random.nextInt(addresses.length)];

        if(random.nextBoolean()){
            return new LargeProvider(name, address, workingTime);
        }

        return new SmallProvider(name, address, workingTime);
    }

    private static ShopingCenter getShopintCenter() {
        Random random = new Random();
        String address = addresses[random.nextInt(addresses.length)];

        ShopingCenter shopingCenter = null;

        switch (random.nextInt(3)){
            case 0 :
                shopingCenter = new Stall(address, workingTime, 5); // area 2-10
                break;
            case 1 :
                shopingCenter = new MallShop(address, workingTime, 50); // area 10-100
                break;
            case 2 :
                shopingCenter =  new Pavilion(address, workingTime, 6); // area 4-6
                break;
        }

        return shopingCenter;
    }

}
