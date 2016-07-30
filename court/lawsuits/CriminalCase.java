package lawsuits;

import citizens.Defendant;
import citizens.Witness;
import contracts.IProsecutor;
import court.Court;
import courtEmployees.Prosecutor;

import java.util.HashSet;

/**
 * Created by Parapanov on 29/07/2016.
 */
public class CriminalCase extends Lawsuit {

    public CriminalCase(Court court, Defendant defendant, Prosecutor prosecutor) {
        super(court, defendant, prosecutor);
    }


    @Override
    public void setJurors(Court court) {
//        13
        while (this.getJurorsCount() < 13){
            this.setJurors(court.getJoror());
        }
    }

    @Override
    public void prosecutorAskQuestions(Defendant defendant, IProsecutor prosecutor, HashSet<Witness> witnesses) {
//        Ако делото е наказателно, прокурора задава 5 въпроса на обвиняемия,
//        след което задава по 5 въпроса на всеки от свидетелите

        for (int i = 0; i < 5; i++) {
            System.out.println(prosecutor + " ask question " + (i + 1) + " defendant " + defendant);
        }

        for (Witness witness : witnesses) {
            for (int i = 0; i < 5; i++) {
                System.out.println(prosecutor + " ask question " + (i + 1) + " witness " + witness);
            }
        }
    }


}
