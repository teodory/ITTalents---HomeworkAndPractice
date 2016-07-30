package courtEmployees;

import exceptions.InvalidCourtEmployeeException;
import randomGenerator.MyRandom;

/**
 * Created by Parapanov on 29/07/2016.
 */
public class Judge extends CourtEmployee {

    private int internshipYears;

    public Judge(String name, int internshipYears, int lawsuitCount) throws InvalidCourtEmployeeException {
        super(name, internshipYears, lawsuitCount);
        this.setInternshipYears(internshipYears);
    }

    private void setInternshipYears(int internshipYears) throws InvalidCourtEmployeeException {
        if(internshipYears < 5){
            throw new InvalidCourtEmployeeException("Invalid internship years");
        }
        this.internshipYears = internshipYears;
    }

    public int getVerdict() {
        return MyRandom.random.nextInt(48) + 3;
    }
}
