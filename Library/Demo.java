package Labrary;

import Labrary.readModels.Book;

/**
 * Created by Parapanov on 23/08/2016.
 */
public class Demo {

    public static void main(String[] args) {

        Library library = new Library("Norodna biblioteka");

        Book book1 = new Book("Nqkva kniga", "Nqkvo izdatelstvo", "AvToR", 2016, 1 , 1, "Deeba" );
        Book book2 = new Book("Tupa kniga", "Nqkvo izdatelstvo", "AvToR", 2015, 1 , 1, "Deeba" );
        Book book3 = new Book("Druga", "Izdatelstvo", "AvToRYt", 2001, 10 , 15, "Drama" );

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        Reader pesho = new Reader("Pesho", library);
        pesho.getBook("Drama", "Druga");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pesho.returnBook();
    }
}
