package io.github.andyradionov.javajokeslib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Joker {

    private static List<String> JOKES = readJokeFile();;
    private static final Random RANDOM = new Random();

    //For test only
    public static void main(String[] args) {
        String s = new Joker().getJoke();
        System.out.println(s);
    }

    public String getJoke() {
        int index = RANDOM.nextInt(JOKES.size());
        return JOKES.remove(index);
    }

    private static List<String> readJokeFile() {

        InputStream in = Joker.class.getResourceAsStream("/jokes.txt");
        if (in == null) {
            return Collections.emptyList();
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))){

            ArrayList<String> jokesList = new ArrayList<>();
            String joke;
            while ((joke = reader.readLine()) != null){
                jokesList.add(joke);
            }
            return jokesList;
        } catch (IOException e) {
            return Collections.emptyList();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

   /* private static List<String> readJokeFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("jokes.txt"))) {

            ArrayList<String> jokesList = new ArrayList<>();
            String joke;
            while ((joke = reader.readLine()) != null){
                jokesList.add(joke);
            }
            return jokesList;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }*/
}
