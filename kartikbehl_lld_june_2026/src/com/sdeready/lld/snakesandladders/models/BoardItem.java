package com.sdeready.lld.snakesandladders.models;

public class BoardItem {
    private final int start;
    private final int end;
    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
    public BoardItem(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
