package com.sdeready.lld.snakesandladders.strategy;

import com.sdeready.lld.snakesandladders.models.Board;
import com.sdeready.lld.snakesandladders.models.Player;

public interface WinningStrategy {
    boolean hasWon(Player player, Board board);
}
