package com.sdeready.lld.snakesandladders.models;

public class Player {

    private String name;
    private int currentPosition;
    private int rank;
    private boolean hasWon;

    public boolean isHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Player(String name) {
        this.name = name;
        this.currentPosition = 0;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getRank() {
        return rank;
    }

    public void move(int position) {
        setCurrentPosition(position);
    }

}
