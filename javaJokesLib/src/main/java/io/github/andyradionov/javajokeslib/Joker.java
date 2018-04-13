package io.github.andyradionov.javajokeslib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Joker {

    private static List<String> JOKES;
    private static final Random RANDOM = new Random();

    //For test only
    public static void main(String[] args) {
        String s = new Joker().getJoke();
        System.out.println(s);
    }

    public Joker() {
        initInMemoryJokes();
    }

    public String getJoke() {
        int index = RANDOM.nextInt(JOKES.size());
        return JOKES.get(index);
    }

    private static void initInMemoryJokes() {
        JOKES = new ArrayList<>();
        JOKES.add("Police officer talks to a driver: Your tail light is broken, your tires must be exchanged and your bumper hangs halfway down. That will be 300 dollars.\nDriver: Alright, go ahead. They want twice as much as that at the garage.");
        JOKES.add("Why did the physics teacher break up with the biology teacher?\nThere was no chemistry.");
        JOKES.add("Q. Why do the French like to eat snails so much?\nA. They can’t stand fast food.\n");
        JOKES.add("Husband: “Oh the weather is lovely today. Shall we go out for a quick jog?“\nWife: “Hahaha, I love the way you pronounce ‘Shall we go out and have a cake’!");
        JOKES.add("A guest calls the waiter and complains, “How come there are no chairs at our table?!”\nThe waiter shrugs, “I’m sorry but you only booked one table…”\n");
        JOKES.add("Optimist: The glass is half full.\nPessimist: The glass is half empty.\nMother: Why didn’t you use a coaster!\n");
        JOKES.add("I asked my daughter if she’d seen my newspaper. She told me that newspapers are old school. She said that people use tablets nowadays and handed me her iPad. The fly didn’t stand a chance.");
        JOKES.add("I’ve been really depressed lately. A friend told me I should go to the petting zoo perhaps, to cheer up.\nI went today, but not one person would stroke me.\n");
        JOKES.add("I forgot my cell phone when I went to the toilet yesterday. We have 245 tiles.\n");
        JOKES.add("Q. How many gorillas can fit into a car?\nA. Eight.\nQ. How many chickens can fit into the car?\nA. None, the car is already full of gorillas.\n");
        JOKES.add("She: I have a doctor’s appointment today but I really don’t want to go…\nHe: Just call in sick then.\n");
        JOKES.add("A girl asks a boy: \"Peter, how much do you love me?\"\nThe boy looks her in the eyes, \"Look up at the stars, that's how much I love you.\"\nThe girl is confused, “But it’s morning, there are no stars?”\nBoy nods, \"Exactly!\"\n");
        JOKES.add("A recent scientific study showed that out of 2,293,618,367 people, 94% are too lazy to actually read that number.\n");
        JOKES.add("A boy breaks an old vase at a rich uncle‘s house. The uncle gets extremely angry and yells: “Do you even know how old the vase was? It was from the 17th century!” The boy sagged in relief: “Oh, good that it wasn’t new.”\n");
        JOKES.add("I’ve always thought my neighbors were quite nice people. But then they put a password on their Wi-Fi.\n");
    }

    private static void readJokeFile() {

        InputStream in = Joker.class.getResourceAsStream("/jokes.txt");
        if (in == null) {
            JOKES = Collections.emptyList();
            return;
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))){

            JOKES.clear();
            String joke;
            while ((joke = reader.readLine()) != null){
                JOKES.add(joke);
            }
        } catch (IOException e) {
            JOKES = Collections.emptyList();

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
