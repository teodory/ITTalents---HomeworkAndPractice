package lesson29;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Parapanov on 23/08/2016.
 */
public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        for (int i = 0; i < 5; i++) {

            long start = System.currentTimeMillis();
            System.out.println(readCommas(10));
            long stop = System.currentTimeMillis();

            System.out.println(stop - start);
        }

    }

    private static int readCommas(int threads) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        Set<Future<Integer>> futures = new HashSet<>();

        List<String> textParts = null;
        try {
            textParts = getTextParts(threads);

        } catch (FileNotFoundException e) {
            System.out.println("Book not found!");
            return 0;
        }

        for (int i = 0; i < textParts.size(); i++) {
            CommaReader reader = new CommaReader(textParts.get(i));

            Future<Integer> future = executor.submit(reader);
            futures.add(future);
        }

        int sum = 0;

        for (Future<Integer> future : futures) {
            sum += future.get();
        }

        return sum;
    }

    private static List<String> getTextParts(int threads) throws FileNotFoundException {

        File book = new File("C:\\Users\\Parapanov\\Desktop\\Lev_Tolstoj_-_Vojna_i_mir_-_Pyrvi_i_vtori_tom-4403-b\\Voina_i_mir.txt");
//        if(!book.exists()){
//            throw new FileNotFoundException("Book not found!");
//            return null;
//        }
        StringBuilder bookText = new StringBuilder();
        Scanner scanner = new Scanner(book);

        while (scanner.hasNextLine()){
            bookText.append(scanner.nextLine());
        }

        int partLength = bookText.length() / threads;
        int from = 0;
        int to = from + partLength;


        List<String> parts = new ArrayList<>();
        while (to <= bookText.length()) {
            parts.add(bookText.substring(from, to));
            from = to;
            to = from + partLength;
        }

        return parts;
    }
}
