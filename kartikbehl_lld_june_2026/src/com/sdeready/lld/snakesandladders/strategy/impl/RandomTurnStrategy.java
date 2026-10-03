package com.sdeready.lld.snakesandladders.strategy.impl;

import com.sdeready.lld.snakesandladders.models.Player;
import com.sdeready.lld.snakesandladders.strategy.TurnTakingStrategy;

import java.util.List;
import java.util.Random;

public class RandomTurnStrategy implements TurnTakingStrategy {
    List<Player> players;

    public RandomTurnStrategy(List<Player> players){
        this.players = players;
    }

    @Override
    public Player getNextPlayer() {
        Random random = new Random();
        int selectedIndex = random.nextInt(players.size());
        return players.get(selectedIndex);
    }

    @Override
    public boolean hasNextPlayer() {
        return !players.stream().allMatch(Player::isHasWon);
    }
}
