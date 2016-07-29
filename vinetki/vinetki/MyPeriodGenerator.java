package vinetki;

import java.time.Period;

/**
 * Created by Parapanov on 28/07/2016.
 */
public class MyPeriodGenerator {

    static Period getPeriod(VinetkaPeriod period){
        switch (period){
            case DAY:
                return Period.ofDays(1); // getValue
            case MONTH:
                return Period.ofMonths(1);
            case YEAR:
                return Period.ofYears(1);
            default:
                throw new IllegalArgumentException("Unsupported Period");
        }
    }

}
