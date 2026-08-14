package com.sdeready.lld.snakesandladders.models;

import com.sdeready.lld.snakesandladders.strategy.TurnTakingStrategy;
import com.sdeready.lld.snakesandladders.strategy.WinningStrategy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private final Dice dice;
    private final List<Player> players;
    private final Board board;

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    private boolean gameOver;
    private final TurnTakingStrategy turnStrategy;
    private final WinningStrategy winningStrategy;
    private int playerRank;

    public Game(Dice dice, Board board, List<Player> players, TurnTakingStrategy turnStrategy, WinningStrategy winningStrategy) {
        this.dice = dice;
        this.board = board;
        this.players = players;
        this.turnStrategy = turnStrategy;
        this.winningStrategy = winningStrategy;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void play() throws InterruptedException {
        System.out.println("Starting game...");
        Player player = null;
        while (!isGameOver()) {
            player = turnStrategy.getNextPlayer();
            if(!turnStrategy.hasNextPlayer()) {
                setGameOver(true);
                break;
            }
            System.out.println("Player "+player.getName()+"("+player.getCurrentPosition()+") taking turn...");
            int diceNumber = dice.roll();
            System.out.println("Player "+player.getName()+"("+player.getCurrentPosition()+") rolled a "+diceNumber+"...");

            int position = player.getCurrentPosition() + diceNumber;
            BoardItem boardItem = board.getItem(position);
            System.out.println("Board item: "+boardItem.getStart()+", "+boardItem.getEnd());

            int finalPosition = boardItem.getEnd();
            if (!board.isValidPosition(finalPosition)) {
                System.out.println("Invalid position!");
                continue;
            }
            player.move(finalPosition);
            if(winningStrategy.hasWon(player, board)){
                player.setRank(++playerRank);
                player.setHasWon(true);
                System.out.println("Player "+player.getName()+" won at position "+player.getRank());
            }
            Thread.sleep(100);

        }
        if(player != null){
            player.setRank(++playerRank);
            player.setHasWon(true);
        }

        System.out.println("Game over...");
        List<Player> sortedByRanks = players.stream().sorted((p1, p2) -> p1.getRank() - p2.getRank()).toList();
        System.out.println("Final ranks: ");
        for (int i = 0; i < Math.max(2, players.size()); i++) {
            player = sortedByRanks.get(i);
            System.out.println(player.getRank()+". "+player.getName());
        }
    }
}
