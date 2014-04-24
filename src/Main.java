import com.brett.jumbletron.Jumbletron;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

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

        j.getWords(input);
    }

    private static void quit() {
        System.exit(0);
    }

}

