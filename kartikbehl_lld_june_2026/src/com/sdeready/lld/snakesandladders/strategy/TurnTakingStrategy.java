package com.sdeready.lld.snakesandladders.strategy;

import com.sdeready.lld.snakesandladders.models.Player;

import java.util.List;

public interface TurnTakingStrategy {
    Player getNextPlayer();
    boolean hasNextPlayer();
}
