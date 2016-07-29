package vinetki;

/**
 * Created by Parapanov on 28/07/2016.
 */
public enum  VinetkaPeriod {

    DAY(1),
    MONTH(1),
    YEAR(1);

    private final int value;

    private VinetkaPeriod(int value) {
        this.value = value;
    }
}
