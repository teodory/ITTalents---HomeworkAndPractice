package courtEmployees;

import exceptions.InvalidCourtEmployeeException;

/**
 * Created by Parapanov on 29/07/2016.
 */
public class Lawyer extends CourtEmployee {

    private int lawsuitCount;

    public Lawyer(String name, int internshipYears, int lawsuitCount) throws InvalidCourtEmployeeException {
        super(name, internshipYears, lawsuitCount);
        this.setLawsuitCount(lawsuitCount);
    }

    private void setLawsuitCount(int lawsuitCount) throws InvalidCourtEmployeeException {
        if(lawsuitCount < 10){
            throw new InvalidCourtEmployeeException("Invalid lawsuit count.");
        }
        this.lawsuitCount = lawsuitCount;
    }

//    @Override
//    public int getLawsuitCount() {
//        return this.lawsuitCount;
//    }
}
