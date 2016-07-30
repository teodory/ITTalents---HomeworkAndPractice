import citizens.Citizen;
import citizens.Claimant;
import citizens.Defendant;
import citizens.Witness;
import court.Court;
import courtEmployees.*;
import exceptions.InvalidCourtEmployeeException;
import lawsuits.CivilCase;
import lawsuits.CriminalCase;
import randomGenerator.MyRandom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Parapanov on 29/07/2016.
 */
public class Demo {

    public static void main(String[] args) throws InvalidCourtEmployeeException {
//        1.
        Court court = new Court("Rayonen Sud VT","Veliko Turnovo");

//        2.
        List<CourtEmployee> courtEmployees = new ArrayList<>();
        setJudges(courtEmployees, 3);
        setJurors(courtEmployees, 15);
        setLawyers(courtEmployees, 5);
        setProsecutors(courtEmployees, 2);

        court.addEmployees(courtEmployees);

//        3. Създаване на граждани – 5 обвинителя, 5 обвиняеми и 10 свидетеля.
        List<Citizen> citizens = new ArrayList<>();
        setClaimants(citizens, 5);
        setDefendants(citizens, 5);
        setWitnesses(citizens, 10);

//        4. Създаване на три граждански дела.
//          За всяко дело юристите и гражданите се зачисляват на произволен принцип.
        Defendant defendant = getDefendant(citizens, courtEmployees);
        Claimant claimant = getClaimant(citizens, courtEmployees);
        CivilCase civilCase1 = new CivilCase(court, defendant, claimant);

        defendant = getDefendant(citizens, courtEmployees);
        claimant = getClaimant(citizens, courtEmployees);
        CivilCase civilCase2 = new CivilCase(court, defendant, claimant);

        defendant = getDefendant(citizens, courtEmployees);
        claimant = getClaimant(citizens, courtEmployees);
        CivilCase civilCase3 = new CivilCase(court, defendant, claimant);

//        5. Създаване на три наказателни дела.
//          За всяко дело юристите и гражданите се зачисляват на произволен принцип.
        Prosecutor prosecutor = getRandomProsecutor(courtEmployees);
        defendant = getDefendant(citizens, courtEmployees);
        CriminalCase criminalCase1 = new CriminalCase(court, defendant, prosecutor);

        prosecutor = getRandomProsecutor(courtEmployees);
        defendant = getDefendant(citizens, courtEmployees);
        CriminalCase criminalCase2 = new CriminalCase(court, defendant, prosecutor);

        prosecutor = getRandomProsecutor(courtEmployees);
        defendant = getDefendant(citizens, courtEmployees);
        CriminalCase criminalCase3 = new CriminalCase(court, defendant, prosecutor);

        court.addLawsuit(civilCase1);
        court.addLawsuit(civilCase2);
        court.addLawsuit(civilCase3);
        court.addLawsuit(criminalCase1);
        court.addLawsuit(criminalCase2);
        court.addLawsuit(criminalCase3);

        court.printStatus();
        System.out.println("--------------------------------------------------------------");
        court.executeLawsuit();

        System.out.println("--------------------------------------------------------------");
        court.printStatus();
    }

    private static Prosecutor getRandomProsecutor(List<CourtEmployee> courtEmployees) {
        List<Prosecutor> prosecutors = new ArrayList<>();
        for (CourtEmployee courtEmployee : courtEmployees) {
            if(courtEmployee instanceof Prosecutor){
                prosecutors.add((Prosecutor) courtEmployee);
            }
        }

        return prosecutors.get(MyRandom.random.nextInt(prosecutors.size()));
    }

    private static Claimant getClaimant(List<Citizen> citizens, List<CourtEmployee> courtEmployees) {
        List<Claimant> claimants = new ArrayList<>();

        for (Citizen citizen : citizens) {
            if(citizen instanceof Claimant){
                claimants.add((Claimant) citizen);
            }
        }
        Claimant toReturn = claimants.get(MyRandom.random.nextInt(claimants.size()));
        toReturn.setLawyers(getRandomLawyers(courtEmployees));
        return toReturn;
    }

    private static Defendant getDefendant(List<Citizen> citizens, List<CourtEmployee> courtEmployees) {
        List<Defendant> defendants = new ArrayList<>();

        for (Citizen citizen : citizens) {
            if (citizen instanceof  Defendant){
                Defendant defendant = (Defendant) citizen;
                defendants.add(defendant);
            }
        }

        Defendant toReturn = defendants.get(MyRandom.random.nextInt(defendants.size()));
        toReturn.setLawyers(getRandomLawyers(courtEmployees));
        return toReturn;
    }

    private static List<Lawyer> getRandomLawyers(List<CourtEmployee> courtEmployees) {
        int lawyersCount = MyRandom.random.nextInt(5); // maximum 5 layers
        List<Lawyer> lawyers = new ArrayList<>();
        while (lawyers.size() < lawyersCount){

            for (CourtEmployee courtEmployee : courtEmployees) {
                if(courtEmployee instanceof  Lawyer){
                    lawyers.add((Lawyer) courtEmployee);
                }
            }
        }
        return lawyers;
    }

    private static void setWitnesses(List<Citizen> citizens, int count) {
        List<Witness> witnesses = new ArrayList<>();
        while (witnesses.size() < count){
            Witness witness = new Witness(MyRandom.getName(), "Bulgaria", 33);
            witnesses.add(witness);
        }
        citizens.addAll(witnesses);
    }

    private static void setDefendants(List<Citizen> citizens, int count) {
        List<Defendant> defendants = new ArrayList<>();
        while (defendants.size() < count){
            Defendant defendant = new Defendant(MyRandom.getName(), "Bulgaria", 33);
            defendants.add(defendant);
        }
        citizens.addAll(defendants);
    }

    private static void setClaimants(List<Citizen> citizens, int count) {
        List<Claimant> claimants = new ArrayList<>();
        while (claimants.size() < count){
            Claimant claimant = new Claimant(MyRandom.getName(), "Bulgaria", 33);
            claimants.add(claimant);
        }
        citizens.addAll(claimants);
    }

    private static void setProsecutors(List<CourtEmployee> courtEmployees, int count) {
        List<Prosecutor> prosecutors = new ArrayList<>();
        while (prosecutors.size() < count){
            try {
                Prosecutor prosecutor = new Prosecutor(MyRandom.getName(), MyRandom.random.nextInt(20), MyRandom.random.nextInt(20));
                prosecutors.add(prosecutor);

            } catch (InvalidCourtEmployeeException e) {
                System.out.println(e.getMessage());
            }
        }

        courtEmployees.addAll(prosecutors);
    }

    private static void setLawyers(List<CourtEmployee> courtEmployees, int count) {
        List<Lawyer> lawyers = new ArrayList<>();
        while (lawyers.size() < count){
            try {
                Lawyer lawyer = new Lawyer(MyRandom.getName(), MyRandom.random.nextInt(20), MyRandom.random.nextInt(20));
                lawyers.add(lawyer);
            } catch (InvalidCourtEmployeeException e) {
                System.out.println(e.getMessage());
            }
        }

        courtEmployees.addAll(lawyers);
    }

    private static void setJurors(List<CourtEmployee> courtEmployees, int count) {
        ArrayList<Juror> jurors = new ArrayList<>();
        while (jurors.size() < count){
            Juror juror = new Juror(MyRandom.getName(), MyRandom.random.nextInt(20), MyRandom.random.nextInt(20));
            jurors.add(juror);
        }
        courtEmployees.addAll(jurors);
    }

    private static void setJudges(List<CourtEmployee> courtEmployees, int count) {
        ArrayList<Judge> judges = new ArrayList<>();
        while (judges.size() < count){
            try {
                Judge judge = new Judge(MyRandom.getName(), MyRandom.random.nextInt(20), MyRandom.random.nextInt(20));
                judges.add(judge);
            } catch (InvalidCourtEmployeeException e) {
                System.out.println(e.getMessage());
            }
        }

        courtEmployees.addAll(judges);
    }
}
