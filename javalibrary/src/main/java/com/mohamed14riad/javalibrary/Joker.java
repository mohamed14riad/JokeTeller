package com.mohamed14riad.javalibrary;

import java.util.ArrayList;
import java.util.Random;

public class Joker {

    private static ArrayList<String> jokes = new ArrayList<>();

    static {
        jokes.add("Here is a joke: I love pressing F5. It's so refreshing.");
        jokes.add("A TCP packet walks into a bar and says, \"I'd like a beer.\"\nThe bartender replies, \"You want a beer?\"\nThe TCP packet replies, \"Yes, I'd like a beer.\"");
        jokes.add("What do you call 8 hobbits?\nA hobbyte");
        jokes.add("Have you heard of that new band \"1023 Megabytes\"? They're pretty good, but they don't have a gig just yet.");
        jokes.add("We'll we'll we'll...if it isn't autocorrect.");
        jokes.add("Autocorrect has become my worst enema.");
        jokes.add("Q: Why was the cell phone wearing glasses?\nA: It lost its contacts.");
        jokes.add("I love pressing F5. It's so refreshing.");
        jokes.add("I'd tell you a joke about UDP, but you probably wouldn't get it.");
        jokes.add("Q: How did you like my HTTP 200 joke ?\nA: It was Ok.");
        jokes.add("I ran out of new IPv4 jokes. I could tell you an IPv6 one but I'm afraid, you might not understand it.");
        jokes.add("Why do Java devs need glasses? Because they don't C#.");
    }

    public static String getJoke() {
        Random random = new Random();
        int i = random.nextInt(jokes.size());
        return jokes.get(i);
    }
}
