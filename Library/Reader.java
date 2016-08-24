package Library;

import Library.exceptions.NoSuchGenreException;
import Library.readModels.Book;

/**
 * Created by Parapanov on 24/08/2016.
 */
public class Reader {

    private String name;
    private Book book;
    private Library library;


    public Reader(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    public void getBook(String gender, String name){
        try {
            this.book = library.getBook(gender, name);
        } catch (NoSuchGenreException e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(){
        this.library.returnBook(this.book);
        this.book = null;
    }
}
