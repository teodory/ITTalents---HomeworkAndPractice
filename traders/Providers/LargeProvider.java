package Providers;

/**
 * Created by Parapanov on 19/07/2016.
 */
public class LargeProvider extends Provider {

    public LargeProvider(String name, String address, String workingTime) {
        super(name, address, workingTime);
    }

    @Override
    protected double getDiscount(double totalCoast) {
        return totalCoast * 0.15;
    }
}
