package citizens;

import courtEmployees.Lawyer;

import java.util.List;

/**
 * Created by Parapanov on 29/07/2016.
 */
public abstract class Citizen {

    private String name;
    private String address;
    private int age;

    public Citizen(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public abstract void setLawyers(List<Lawyer> lawyers);
}
