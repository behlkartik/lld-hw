package com.sdeready.lld.snakesandladders.models;

import java.util.*;

public class Board {
    public int getSize() {
        return row * col;
    }

    public Map<Integer, BoardItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, BoardItem> items) {
        this.items = items;
    }

    private int row;
    private int col;
    private int size;
    private Map<Integer, BoardItem> items;
    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        this.size = row * col;
        this.items = new HashMap<>(size * size);
        for(int i = 0; i < size * size; i++)
            items.put(i, new BoardItem(i, i));
    }

    public boolean canPlace(BoardItem item) {
        return isValidPosition(item.getStart())
                && isValidPosition(item.getEnd())
                && items.get(item.getStart()).getClass().equals(BoardItem.class)
                && items.get(item.getEnd()).getClass().equals(BoardItem.class);
    }

    public boolean isValidPosition(int position) {
        return position >= 0 && position < this.getSize();
    }

    public void addItem(BoardItem item) {
        if(!canPlace(item)){
            throw new IllegalArgumentException("Invalid position:" + item.getStart() + ", "+ item.getEnd());
        }
        items.put(item.getStart(), item);
        items.put(item.getEnd(), item);
    }

    public BoardItem getItem(int position) {
        return items.get(position);
    }

}
