import com.brett.jumbletron.Jumbletron;
import com.brett.utilities.Permutations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        System.out.println("Welcome to Jumbletron. ");

        System.out.println("Please wait while Jumbletron initializes");
        Jumbletron j = new Jumbletron();
        System.out.println("Jumbletron intialized");

        while (true) {
            String input;

            System.out.println("Feed jumbletron a word (or press return to quit): ");
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

            try {
                input = bufferRead.readLine();
                handleInput(j, input);

            } catch (IOException e) {
                e.printStackTrace();
                quit();
            }

        }
    }

    private static void handleInput(Jumbletron j, String input) {
        if (input.equals("")) {
            System.out.println("Goodbye!");
            quit();
        }

        Set<String> matchingWords = j.solve(input);

        if (matchingWords.size() > 0) {
            System.out.println(String.format("Found %s following words: ", matchingWords.size()));
            for (String word : matchingWords) {
                System.out.println(word);
            }
        } else {
            System.out.println("No words found! :(");
        }

    }

    private static void quit() {
        System.exit(0);
    }

}

