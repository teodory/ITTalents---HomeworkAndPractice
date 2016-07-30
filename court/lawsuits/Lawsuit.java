package lawsuits;


import citizens.Defendant;
import citizens.Witness;
import contracts.IProsecutor;
import court.Court;
import courtEmployees.*;
import courtEmployees.Lawyer;
import courtEmployees.Prosecutor;

import java.util.HashSet;
import java.util.List;

public abstract class Lawsuit {

    private Judge judge;
    private HashSet<Juror> jurors;
    private Defendant defendant;       // обвиняем
    private IProsecutor prosecutor;  // обвинител
    private HashSet<Witness> witnesses; // свидетели

    public Lawsuit(Court court, Defendant defendant, IProsecutor prosecutor) {
         // may need to be random generated
        this.defendant = defendant;
        this.prosecutor = prosecutor;

        this.jurors = new HashSet<>();
        this.witnesses = new HashSet<>();
        this.judge = court.getJudge();
        setJurors(court);
    }

    public void setWitnesses(List<Witness> witnesses){
        this.witnesses.addAll(witnesses);
    }

    public abstract void setJurors(Court court);

    public void executeLawsuit(){

        this.judge.increaseLawsuitCount();

        for (Juror juror : this.jurors) {
            juror.increaseLawsuitCount();
        }

        if (prosecutor instanceof Prosecutor){
            ((Prosecutor) prosecutor).increaseLawsuitCount();
        }

        for (Lawyer lawyer : this.defendant.getLawyers()) {
            lawyer.increaseLawsuitCount();
        }

        this.prosecutorAskQuestions(this.defendant, this.prosecutor, this.witnesses);

        this.defendantAskQuestion(this.defendant, this.witnesses);

        boolean isGuilty = this.jurorsTakeDecision();

        if(isGuilty){
            System.out.println(defendant + " is guilty!");
            System.out.println(judge.getVerdict() + " in prison!");
        }else {
            System.out.println(defendant + " is innocent!");
        }
    }

    private boolean jurorsTakeDecision() {
        int guiltyCount = 0;

        while (true){
            for (Juror juror : this.jurors) {
                if(juror.takeDecision()){
                    guiltyCount++;
                }
            }
            if(guiltyCount != (this.jurors.size() / 2)){
                break;
            }
        }

        return guiltyCount > this.jurors.size() / 2;
    }

    public abstract void prosecutorAskQuestions(Defendant defendant, IProsecutor prosecutor, HashSet<Witness> witnesses);

    public void defendantAskQuestion(Defendant defendant, HashSet<Witness> witnesses) {
//        Всеки адвокат на обвиняемия задава по 5 въпроса на свидетелите по делото.
        for (Lawyer lawyer : defendant.getLawyers()) {
            for (Witness witness : witnesses) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(lawyer + " ask question " + (i+1) + " witness " + witness);
                }
            }
        }
    }

    protected int getJurorsCount(){
        return this.jurors.size();
    }

    protected void setJurors(Juror juror){
        this.jurors.add(juror);
    }
}
