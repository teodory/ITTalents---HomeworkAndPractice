package lesson29;

import java.util.concurrent.Callable;

/**
 * Created by Parapanov on 23/08/2016.
 */
public class CommaReader implements Callable<Integer> {

    public static final int COMMA_NUMBER = 44;

    private String text;

    public CommaReader(String text){
        this.text = text;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;

        for (int i = 0; i < this.text.length(); i++) {
            if(this.text.charAt(i) == COMMA_NUMBER){
                count++;
            }

        }

        return count;
    }
}
