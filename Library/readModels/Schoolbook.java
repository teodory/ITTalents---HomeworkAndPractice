package Labrary.readModels;

/**
 * Created by Parapanov on 23/08/2016.
 */
public class Schoolbook extends Read {

    private String author;
    private String theme;

    private Schoolbook(String name, String publishing, String author, String theme) {
        super(name, publishing);
        this.author = author;
        this.theme = theme;
    }
}
