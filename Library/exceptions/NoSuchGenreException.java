package Labrary.exceptions;

/**
 * Created by Parapanov on 24/08/2016.
 */
public class NoSuchGenreException extends Exception {

    private String message;

    public NoSuchGenreException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

