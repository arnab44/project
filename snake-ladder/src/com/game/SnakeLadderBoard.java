package com.game;

import java.util.List;
import java.util.Random;

public class SnakeLadderBoard implements GameBoard {
    private final int size;
    private final Dice dice;
    private final List<Jumpables> jumpables;
    public Token[] board;
    public boolean hasGameWon;
    public SnakeLadderBoard(int size, Dice dice, List<Jumpables> jumpables, boolean hasGameWon) {
        this.size = size;
        this.jumpables = jumpables;
        this.dice = dice;
        this.hasGameWon = hasGameWon;
    }

    @Override
    public void initialize() {
        this.board = new Token[size+1];
    }

    @Override
    public void move(Token token) {
        int turn = rollDice();
        moveToken(turn, token);
    }

    private void moveToken(int turn, Token token) {
        int currentPosition = token.getPosition();
        int newPosition = currentPosition + turn;
        if (newPosition == size) {
            token.setPosition(newPosition);
            this.hasGameWon = true;
        } else if (newPosition < size) {
            token.setPosition(newPosition);
            jumpables.stream().filter(j -> j.getStart() == newPosition).findFirst().ifPresent(j -> {
                token.setPosition(j.getEnd());
                moveToken(0, token);
            });
        } else {}

    }

    private int rollDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
