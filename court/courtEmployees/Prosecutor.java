package courtEmployees;

import contracts.IProsecutor;
import exceptions.InvalidCourtEmployeeException;

/**
 * Created by Parapanov on 29/07/2016.
 */
public class Prosecutor extends CourtEmployee implements IProsecutor {

    private int internshipYears;

    public Prosecutor(String name, int internshipYears, int lawsuitCount) throws InvalidCourtEmployeeException {
        super(name, internshipYears, lawsuitCount);
        this.setInternshipYears(internshipYears);
    }

    private void setInternshipYears(int internshipYears) throws InvalidCourtEmployeeException {
        if(internshipYears <10){
            throw new InvalidCourtEmployeeException("Invalid internship years.");
        }
        this.internshipYears = internshipYears;
    }
}
