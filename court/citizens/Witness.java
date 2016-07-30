package citizens;

import courtEmployees.Lawyer;

import java.util.List;

/**
 * Created by Parapanov on 29/07/2016.
 */
public class Witness extends Citizen {

    public Witness(String name, String address, int age) {
        super(name, address, age);
    }

    @Override
    public void setLawyers(List<Lawyer> lawyers) {
        // do nothing
    }

}
