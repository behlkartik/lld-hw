package com.sdeready.lld.snakesandladders.strategy.impl;

import com.sdeready.lld.snakesandladders.models.Board;
import com.sdeready.lld.snakesandladders.models.Player;
import com.sdeready.lld.snakesandladders.strategy.WinningStrategy;

public class StrictWinningStrategy implements WinningStrategy {
    @Override
    public boolean hasWon(Player player, Board board) {
        return player.getCurrentPosition() == board.getSize() - 1;
    }
}
