package courtEmployees;

import randomGenerator.MyRandom;

/**
 * Created by Parapanov on 29/07/2016.
 */
public class Juror extends CourtEmployee {

    public Juror(String name, int internshipYears, int lawsuitCount) {
        super(name, internshipYears, lawsuitCount);
    }

    public boolean takeDecision() {
        return MyRandom.random.nextBoolean();
    }
}
