package lesson29;

import java.util.concurrent.Callable;

/**
 * Created by Parapanov on 23/08/2016.
 */
public class SomeCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        return 10;
    }
}
