package com.sdeready.lld.snakesandladders.models;

public class Snake extends BoardItem {
    public Snake(int start, int end) {
        super(start, end);
        if(start < end){
            throw new IllegalArgumentException("start can't be < end for Snake");
        }
    }
}
