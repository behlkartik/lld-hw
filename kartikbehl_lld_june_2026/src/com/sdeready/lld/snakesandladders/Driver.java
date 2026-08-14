package com.sdeready.lld.snakesandladders;

import com.sdeready.lld.snakesandladders.models.*;
import com.sdeready.lld.snakesandladders.strategy.*;

import java.util.*;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("======Snakes and Ladders======");
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many faced dice you want?");
        Dice dice = new Dice(scanner.nextInt());

        // using 10 rows
        System.out.println("How many rows?");
        int row = scanner.nextInt();
        // using 10 cols
        System.out.println("How many columns?");
        int col = scanner.nextInt();
        Board board = new Board(row, col);
        System.out.println("Board size: "+board.getSize());

        System.out.println("How many snakes?");
        int snakes = scanner.nextInt();
        scanner.nextLine();
        while (snakes > 0) {
            System.out.println("Enter snake positions start,end comma separated:");
            String[] snakePos = scanner.nextLine().split(",");
            try {
                board.addItem(new Snake(Integer.parseInt(snakePos[0].trim()), Integer.parseInt(snakePos[1].trim())));
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            snakes--;
        }
        System.out.println("How many ladders?");
        int ladders = scanner.nextInt();
        scanner.nextLine();
        while (ladders > 0) {
            System.out.println("Enter ladder positions start,end comma separated:");
            String[] ladderPos = scanner.nextLine().split(",");
            try {
                board.addItem(new Ladder(Integer.parseInt(ladderPos[0].trim()), Integer.parseInt(ladderPos[1].trim())));
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            ladders--;
        }
        List<Player> players = new ArrayList<>();
        System.out.println("How many players?");
        int playerCount = scanner.nextInt();
        if(playerCount < 2)
            throw new IllegalArgumentException("Player count must be greater >= 2");
        for(int i = 0; i < playerCount; i++) {
            System.out.println("Enter player name: ");
            String playerName = scanner.next();
            players.add(new Player(playerName));
        }
        TurnTakingStrategy turnTakingStrategy = null;
        System.out.println("Choose turn strategy: ");
        System.out.println("1: Round Robin");
        System.out.println("2: Random");
        int choice = scanner.nextInt();
        turnTakingStrategy = switch (choice){
            case 1 -> new RoundRobinTurnStrategy(players);
            case 2 -> new RandomTurnStrategy(players);
            default -> throw new IllegalArgumentException("Invalid choice");
        };
        System.out.println("Using turn strategy..." + turnTakingStrategy.getClass().getSimpleName());

        WinningStrategy winningStrategy = new StrictWinningStrategy();
        System.out.println("Using default win strategy..." + winningStrategy.getClass().getSimpleName());

        Game game = new Game(dice, board, players, turnTakingStrategy, winningStrategy);
        System.out.println("Starting game....");
        game.play();
    }
}
