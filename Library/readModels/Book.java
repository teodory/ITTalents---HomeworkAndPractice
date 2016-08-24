package Library.readModels;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * Created by Parapanov on 23/08/2016.
 */
public class Book extends Read {

    public static final double BOX_TAX = 2;

    private String author;
    private LocalDate dateOfCreation;
    private String genre;

    public Book(String name,
                 String publishing,
                 String author,
                 int year,
                 int month,
                 int day,
                 String genre) {

        super(name, publishing);
        this.author = author;
        this.setDateOfCreation(year, month, day);
        this.genre = genre;
    }

    private void setDateOfCreation(int year, int month, int day) throws DateTimeException {
        this.dateOfCreation = LocalDate.of(year, month, day);
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public String getGenre() {
        return genre;
    }
}
