package com.sdeready.lld.snakesandladders.models;

import java.util.*;

public class Board {
    private final int size;
    private Map<Integer, BoardItem> items;
    private int snakes;
    private int ladders;
    private Set<Integer> occupiedItems;

    public Board(int size, int snakes, int ladders) {
        this.size = size;
        this.items = new HashMap<>(size);
        this.snakes = snakes;
        this.ladders = ladders;
        this.occupiedItems = new HashSet<>();
    }

    public int getSnakes() {
        return snakes;
    }

    public int getLadders() {
        return ladders;
    }

    public Map<Integer, BoardItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, BoardItem> items) {
        this.items = items;
    }

    public int getSize() {
        return size;
    }

    public boolean canPlace(BoardItem item) {
        return isValidPosition(item.getStart())
                && isValidPosition(item.getEnd())
                && !occupiedItems.contains(item.getStart())
                && !occupiedItems.contains(item.getEnd());
    }

    public boolean isValidPosition(int position) {
        return position < this.getSize();
    }

    public void addItem(BoardItem item) {
        if(!canPlace(item)){
            throw new IllegalArgumentException("Invalid position for item:" + item.getClass().getSimpleName() + "(" + item.getStart() + ", "+ item.getEnd() + ")");
        }
        items.put(item.getStart(), item);
        occupiedItems.add(item.getStart());
        occupiedItems.add(item.getEnd());
    }

    public BoardItem getItem(int position) {
        return items.get(position);
    }

    public void movePlayer(Player player, int diceNumber) {
        int position = player.getCurrentPosition() + diceNumber;
        if(!isValidPosition(position)){
            System.out.println("Invalid position!");
            return;
        }
        BoardItem boardItem = getItem(position);
        System.out.println("Board item: "+boardItem.getStart()+", "+boardItem.getEnd());

        int finalPosition = boardItem.getEnd();
        if (!isValidPosition(finalPosition)) {
            System.out.println("Invalid position!");
            return;
        }
        player.move(finalPosition);
    }

    private void addItems(int itemSize, String itemType){
        Scanner scanner = new Scanner(System.in);
        while (itemSize > 0){
            System.out.println("Enter "+ itemType +" positions start,end comma separated:");
            String[] snakePos = scanner.nextLine().split(",");
            try {
                int start = Integer.parseInt(snakePos[0].trim());
                int end = Integer.parseInt(snakePos[1].trim());
                BoardItem boardItem = switch (itemType){
                    case "snake" -> new Snake(start, end);
                    case "ladder" -> new Ladder(start, end);
                    default -> throw new IllegalArgumentException("Invalid board item type!");
                };
                addItem(boardItem);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            itemSize--;
        }
    }

    public void placeItems() {
        if(snakes > 0){
            System.out.println("Adding snakes");
            addItems(snakes, "snake");
        }

        if(snakes > 0){
            System.out.println("Adding Ladders");
            addItems(ladders, "ladder");
        }


        for(int i = 1; i < size; i++) {
            try {
                addItem(new BoardItem(i, i));
            } catch (Exception ignored) {
            }
        }
        printBoard();
    }

    private void printBoard() {
        System.out.println("Board:");
        for (Map.Entry<Integer, BoardItem> entry : items.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
