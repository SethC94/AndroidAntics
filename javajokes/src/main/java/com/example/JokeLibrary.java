package com.example;

import java.util.Random;

public class JokeLibrary {
    private Random random = new Random();

    public String getJoke(){
        String joke;
        switch (random.nextInt(2)) {
            case 0:
                joke = "What did one strawberry say to the other? If you weren't so fresh, we wouldn't be in this jam.";
                break;
            default:
                joke = "Patient: Doctor! You've got to help me! Whats growing out of my ears!\n" +
                        "Doctor: Well this is Strange. It appears as though corn is growing out of your ears. Why corn?\n" +
                        "Patient: Beats me. I planted radishes";
                break;

        }
        return joke;

    }
}
