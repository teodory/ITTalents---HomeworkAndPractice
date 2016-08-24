package Labrary.readModels;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * Created by Parapanov on 23/08/2016.
 */
public class Magazine extends Labrary.readModels.Read{

    private String category;
    private int amount;
    private LocalDate dateOfCreation;

    private Magazine(String name, String publishing, String category, int amount, int year, int month, int day) {
        super(name, publishing);
        this.category = category;
        this.amount = amount;
        this.setDateOfCreation(year, month, day);
    }

    private void setDateOfCreation(int year, int month, int day) throws DateTimeException {
        this.dateOfCreation = LocalDate.of(year, month, day);
    }

    public int getAmount() {
        return amount;
    }


}
