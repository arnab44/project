package com.game;

public class Token {
    private final Enum color;
    private int position;


    public Token(Enum color, int position) {
        this.color = color;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        this.position = position;
    }
}
