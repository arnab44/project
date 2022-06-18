package com.game;

import java.util.Arrays;
import java.util.List;

public class GameFactory {
    public static Game createStanderdSnakeLaddeGame() {
        GameBoard board = new SnakeLadderBoard(100, new Dice(6), (List<Jumpables>) Arrays.asList(new Snake(99, 5), new Ladder(12,45), new Ladder(34, 86)), false);
        return new SnakeAndLadderGame(Arrays.asList(), board);
    }
}
