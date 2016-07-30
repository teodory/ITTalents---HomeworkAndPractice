package citizens;

import contracts.IProsecutor;
import courtEmployees.Lawyer;

import java.util.*;

/**
 * Created by Parapanov on 29/07/2016.
 */
public class Claimant extends Citizen implements IProsecutor {

    private HashSet<Lawyer>lawyers;

    public Claimant(String name, String address, int age) {
        super(name, address, age);
        this.lawyers = new HashSet<>();
    }

    @Override
    public void setLawyers(List<Lawyer> lawyers) {
        this.lawyers.addAll(lawyers);
    }

    public Set<Lawyer> getLawyers() {
        return Collections.unmodifiableSet(this.lawyers);
    }
}
