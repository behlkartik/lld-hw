package com.sdeready.lld.snakesandladders.strategy;

import com.sdeready.lld.snakesandladders.models.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RoundRobinTurnStrategy implements TurnTakingStrategy {

    Queue<Player> playersQueue;

    public RoundRobinTurnStrategy(List<Player> players) {
        playersQueue = new LinkedList<>(players);
    }

    @Override
    public Player getNextPlayer() {
        Player player = playersQueue.poll();
        if(player != null && hasNextPlayer() && !player.isHasWon()){
            playersQueue.offer(player);
        }
        return player;
    }

    @Override
    public boolean hasNextPlayer(){
        return !playersQueue.isEmpty();
    }
}
