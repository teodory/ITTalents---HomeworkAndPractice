package Labrary;

import Labrary.exceptions.NoSuchGenreException;
import Labrary.readModels.Book;
import Labrary.readModels.Magazine;
import Labrary.readModels.Schoolbook;
import Labrary.readableThreads.BookChecker;

import java.util.*;

/**
 * Created by Parapanov on 23/08/2016.
 */
public class Library {

    public enum CatalogType {
        BOOK,
        SCHOOLBOOK,
        MAGAZINE
    }

    private String name;

    private TreeMap<String, List<Book>> booksByGenre;
    private TreeMap<String, List<Schoolbook>> schoolbooksByTheme;
    private TreeMap<String, List<Magazine>> magazinesByCategory;

    private HashMap<String, Double> taxes;
    private HashMap<Book, Thread> checkers;

    public Library(String name) {
        this.name = name;
        this.booksByGenre = new TreeMap<>();
        this.schoolbooksByTheme = new TreeMap<>();
        this.magazinesByCategory = new TreeMap<>();

        this.taxes = new HashMap<>();
        this.checkers = new HashMap<>();
    }

    public void printCatalog(CatalogType type){

        switch (type) {
            case BOOK:
                printBooks();
                break;
            case SCHOOLBOOK:
                printSchoolbooks();
                break;
            case MAGAZINE:
                printMagazines();
                break;
            default:
                System.out.println("No such readable object.");
                break;
        }
    }

    private void printMagazines() {
        for (String category : magazinesByCategory.keySet()) {
            System.out.println(category + ": ");
            for (Magazine magazine : magazinesByCategory.get(category)) {
                System.out.println("\"" + magazine.getName() + "\" - " + " pieces " + magazine.getAmount());
            }
        }

    }

    private void printSchoolbooks() {
        for (String theme : schoolbooksByTheme.keySet()) {
            System.out.println(theme + ": ");
            for (Schoolbook schoolbook : schoolbooksByTheme.get(theme)) {
                System.out.println(schoolbook.getName() );
            }
        }
    }

    private void printBooks() {

        for (String bookGenre : booksByGenre.keySet()) {
            System.out.println(bookGenre + ": ");
            List<Book> list = booksByGenre.get(bookGenre);
            Collections.sort(list, (b1, b2) -> b1.getDateOfCreation().compareTo(b2.getDateOfCreation()));
            for (Book book : list) {
                System.out.println(book.getName());
            }
        }
    }

    public void increaseTax(String bookName) {

        double tax = this.taxes.get(bookName);
        double currentTax = tax + (tax * 0.1) ;

        this.taxes.put(bookName, currentTax );
    }

    public void returnBook(Book book) {
        this.checkers.get(book).interrupt();
        System.out.printf("You owe %.2f lv.%n", this.taxes.get(book.getName()));
        this.addBook(book);
        taxes.remove(book.getName());
        checkers.remove(book);
    }

    public void addBook(Book book) {
        if(!booksByGenre.containsKey(book.getGenre())){
            booksByGenre.put(book.getGenre(), new ArrayList<>());
        }

        booksByGenre.get(book.getGenre()).add(book);
    }

    public Book getBook(String genre, String name) throws NoSuchGenreException {
        if(!this.booksByGenre.containsKey(genre)){
            throw new NoSuchGenreException("No such genre!");
        }
        Book book = null;

        for (Book bk : this.booksByGenre.get(genre)) {
            if(bk.getName().equals(name)){
                book = bk;
            }
        }

        if(book == null ){
            throw new NoSuchGenreException("No such book!");
        }

        this.booksByGenre.get(genre).remove(book);

        BookChecker checker = new BookChecker(name, this);
        this.taxes.put(name, Book.BOX_TAX);
        this.checkers.put(book, checker);
        checker.start();

        return book;
    }
}
