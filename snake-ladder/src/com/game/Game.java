package com.game;

import java.util.List;

public abstract class Game {
    private List<Player> players;
    private GameBoard board;
    private Player currentPlayer;

    Game(List<Player> players, GameBoard board) {
        this.players = players;
        this.board = board;
    }
    public void initialize() {
        currentPlayer = players.get(0);

    }

    public void play() {
        board.initialize();
        do {
            currentPlayer.move(board);
            int i = currentPlayer.getIndex();
            int j = (i+1)%players.size();
            currentPlayer = players.get(j);
    } while(!this.hasWon());

}


    private boolean hasWon() {
        return false;
    }
    }