package Providers;

/**
 * Created by Parapanov on 19/07/2016.
 */
public class SmallProvider extends Provider{

    public SmallProvider(String name, String address, String workingTime) {
        super(name, address, workingTime);
    }

    @Override
    protected double getDiscount(double totalCoast) {
        return 0;
    }
}
