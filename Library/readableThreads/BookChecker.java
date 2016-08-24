package Labrary.readableThreads;

import Labrary.Library;

/**
 * Created by Parapanov on 24/08/2016.
 */
public class BookChecker extends Thread{

    public static final int TIME_TO_READ = 2000; //300000

    String bookName;
    Library library;

    public BookChecker(String bookName, Library library) {
        this.bookName = bookName;
        this.library = library;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(TIME_TO_READ);


        } catch (InterruptedException e) {
            return;
        }

        while (!isInterrupted()){
            library.increaseTax(this.bookName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
