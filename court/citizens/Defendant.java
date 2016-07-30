package citizens;

import courtEmployees.Lawyer;

import java.util.*;

/**
 * Created by Parapanov on 29/07/2016.
 */
public class Defendant extends Citizen{

    private HashSet<Lawyer> lawyers;

    public Defendant(String name, String address, int age) {
        super(name, address, age);
        this.lawyers = new HashSet<>();
    }

    public Set<Lawyer> getLawyers() {
        return Collections.unmodifiableSet(this.lawyers);
    }

    @Override
    public void setLawyers(List<Lawyer> lawyers) {
        this.lawyers.addAll(lawyers);
    }

}
