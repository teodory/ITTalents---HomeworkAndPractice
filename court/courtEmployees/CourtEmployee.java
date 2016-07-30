package courtEmployees;

/**
 * Created by Parapanov on 29/07/2016.
 */
public abstract class CourtEmployee {

    private String name;
    private int internshipYears;
    private int lawsuitCount;

    public CourtEmployee(String name, int internshipYears, int lawsuitCount) {
        this.internshipYears = internshipYears;
        this.lawsuitCount = lawsuitCount;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void increaseLawsuitCount(){
        this.lawsuitCount += 1;
    }

    public int getLawsuitCount() {
        return lawsuitCount;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " : " + this.name;
    }


}
