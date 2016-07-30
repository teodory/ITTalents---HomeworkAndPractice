package lawsuits;

import citizens.Claimant;
import citizens.Defendant;
import citizens.Witness;
import contracts.IProsecutor;
import court.Court;
import courtEmployees.Lawyer;

import java.util.HashSet;

/**
 * Created by Parapanov on 29/07/2016.
 */
public class CivilCase extends Lawsuit {

    public CivilCase(Court court, Defendant defendant, Claimant prosecutor) {
        super(court, defendant, prosecutor);
    }

    @Override
    public void setJurors(Court court) {
        // 3
        while (this.getJurorsCount() < 3){
            this.setJurors(court.getJoror());
        }
    }

    @Override
    public void prosecutorAskQuestions(Defendant defendant, IProsecutor prosecutor, HashSet<Witness> witnesses) {
//        Ако делото е гражданско, всеки адвокат на обвинителя задава по 3 въпроса на обвиняемия,
//        след което задава по 2 въпроса на всеки от свидетелите
        for (Lawyer lawyer : ((Claimant) prosecutor).getLawyers()) {
            for (int i = 0; i < 3; i++) {
                System.out.println(lawyer + " ask question " + (i + 1) + " defendant " + defendant);
            }
        }

        for (Lawyer lawyer : ((Claimant) prosecutor).getLawyers()) {
            for (Witness witness : witnesses) {
                for (int i = 0; i < 2; i++) {
                    System.out.println(lawyer + " ask question " + (i + 1) + " witness " + witness);
                }
            }
        }
    }


}
