package com.sdeready.lld.snakesandladders.models;

public class Ladder extends BoardItem{
    public Ladder(int start, int end) {
        super(start, end);
        if(start > end){
            throw new IllegalArgumentException("start can't be > end for Ladder");
        }
    }
}
