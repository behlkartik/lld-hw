package com.sdeready.lld.snakesandladders.service;

import com.sdeready.lld.snakesandladders.models.Board;
import com.sdeready.lld.snakesandladders.models.BoardItem;
import com.sdeready.lld.snakesandladders.models.Dice;
import com.sdeready.lld.snakesandladders.models.Player;
import com.sdeready.lld.snakesandladders.strategy.TurnTakingStrategy;
import com.sdeready.lld.snakesandladders.strategy.WinningStrategy;

import java.util.List;

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

            board.movePlayer(player, diceNumber);
            if(winningStrategy.hasWon(player, board)){
                player.setRank(playerRank);
                player.setHasWon(true);
                playerRank++;
            }
            Thread.sleep(100);

        }
        if(player != null){
            player.setRank(playerRank);
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
