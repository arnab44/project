package com.game;


import java.util.Scanner;

public class HumanPlayer implements Player {
    private final String name;
    private final Token token;
    private final int index;

    public HumanPlayer(String name, Token token, int index) {
        this.name = name;
        this.token = token;
        this.index = index;
    }

    @Override
    public void move(GameBoard board) {
        System.out.println(name + " :Please press any key to roll the dice");
        Scanner s = new Scanner(System.in);
        s.nextLine();
        board.move(this.token);
    }

    @Override
    public int getIndex() {
        return index;
    }

}
