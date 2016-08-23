package lesson29;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Parapanov on 23/08/2016.
 */
public class Demo {

    private static HashMap<String, Integer> words = new HashMap<String, Integer>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//       1. Play with threads
//        for (int i = 0; i < 5; i++) {
//            long start = System.currentTimeMillis();
//            System.out.println(readCommas(10));
//            long stop = System.currentTimeMillis();
//
//            System.out.println(stop - start);
//        }

//        2. Count words
//        countWords();

//        3. print words sorted by length
//        printWordsByLength();

//        4. make files by the length of the words and add them in

        makeFilesWithWordsByLength();
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

        File book = new File("Voina_i_mir.txt");
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

    private static void countWords() {
        try {
            extractWordsFromText();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        words.entrySet()
				.stream()
				.sorted((v1, v2) -> v1.getValue().compareTo(v2.getValue()))
				.forEach(
						en -> System.out.println(en.getKey() + " - "
								+ en.getValue()));
		;
    }

    private static void printWordsByLength() {
        try {
            extractWordsFromText();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        words.keySet().stream().sorted((v1,v2)->{
            if(v2.length()<v1.length()){
                return 1;
            }
            else if(v2.length()>v1.length()){
                return -1;
            }
            return v2.compareTo(v1);

        }).forEach(word->System.out.println(word));
    }

    private static void extractWordsFromText() throws FileNotFoundException {
        File book = new File("Voina_i_mir.txt");
        InputStream stream = new FileInputStream(book);
        Scanner scanner = new Scanner(stream);
        while (scanner.hasNext()) {
            String[] wordWithSymbols = scanner.next().toLowerCase().trim()
                    .split("[-_.,\\s\\d/?!:„;()×—*=“«…\uFEFF№]+");
            if(wordWithSymbols.length==0){
                continue;
            }
            String word = wordWithSymbols[0];
            if(word.length() == 0){
                continue;
            }

            if (words.containsKey(word)) {
                int count = words.get(word);
                count++;
                words.put(word, count);
            } else {
                words.put(word, 1);
            }
        }
    }

    private static void makeFilesWithWordsByLength(){
        try {
            extractWordsFromText();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        for (String word : words.keySet()) {

            int currentLength = word.length();
            String fileName = "words with length" + currentLength+".txt";
            File currentFile = new File(fileName);

            if(!currentFile.exists()){

                try {
                    currentFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try{
                    FileWriter fileWriter = new FileWriter(currentFile, true);
                    fileWriter.write(word + ", ");
                    fileWriter.flush();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
