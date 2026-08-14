package com.sdeready.lld.snakesandladders.models;
import java.util.Random;

public class Dice {
    private int faces;

    public int getFaces() {
        return faces;
    }

    public Dice(int faces) {
        this.faces = faces;
    }

    public int roll() {
        Random rand = new Random();
        return rand.nextInt(1, faces + 1);
    }
}
