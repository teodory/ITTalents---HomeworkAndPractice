package ShopingCenters;

/**
 * Created by Parapanov on 19/07/2016.
 */
public class Stall extends ShopingCenter implements SoleShopingCenter {
    private static final int STALL_TAXES = 50;

    public Stall(String address, String workingTime, int area) {
        super(address, workingTime, STALL_TAXES, area);
    }
}
