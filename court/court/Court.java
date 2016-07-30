package court;

import courtEmployees.CourtEmployee;
import courtEmployees.Judge;
import courtEmployees.Juror;
import lawsuits.Lawsuit;
import randomGenerator.MyRandom;

import java.util.*;

/**
 * Created by Parapanov on 29/07/2016.
 */
public class Court {

    private String name;
    private String address;
    private List<CourtEmployee> courtEmployees;
    private List<Lawsuit> lawsuits;

    public Court(String name, String address) {
        this.name = name;
        this.address = address;
        this.courtEmployees = new ArrayList<>();
        this.lawsuits = new ArrayList<>();
    }

    public void executeLawsuit(){
        for (Lawsuit lawsuit : this.lawsuits) {
            lawsuit.executeLawsuit();
            System.out.println("=================================================================");
        }
    }

    public Juror getJoror() {
//        get all jurors from court employees
        List<Juror> jurors = new ArrayList<>();
        for (CourtEmployee courtEmployee : courtEmployees) {
            if(courtEmployee instanceof Juror){
                jurors.add((Juror) courtEmployee);
            }
        }
//        return random juror
        //TODO check for null
        return jurors.get(MyRandom.random.nextInt(jurors.size()));
    }

    public Judge getJudge() {
//        get all judjes from court employees
        List<Judge> judges = new ArrayList<>();

        for (CourtEmployee courtEmployee : this.courtEmployees) {
            if(courtEmployee instanceof Judge){
                judges.add((Judge) courtEmployee);
            }
        }
//        return random judge
        //TODO check for null

        return judges.get(MyRandom.random.nextInt(judges.size()));
    }

    public void addLawsuit(Lawsuit lawsuit){
        this.lawsuits.add(lawsuit);
    }

    public void addEmployees(List<CourtEmployee> courtEmployees){
        this.courtEmployees.addAll(courtEmployees);
    }

    public void printStatus(){
        TreeMap<String, CourtEmployee> courtEmployeeMap = new TreeMap<>();

        for (CourtEmployee courtEmployee : this.courtEmployees) {
            courtEmployeeMap.put(courtEmployee.getName(), courtEmployee);
        }

        for(Iterator<Map.Entry<String, CourtEmployee>> iterator = courtEmployeeMap.entrySet().iterator(); iterator.hasNext();){
            Map.Entry<String , CourtEmployee> currentEntry = iterator.next();
            System.out.println(currentEntry.getKey() + " - " +
                    currentEntry.getValue().getLawsuitCount() + " - " +
                    currentEntry.getValue().getClass().getSimpleName());

        }
        System.out.println();
    }
}
