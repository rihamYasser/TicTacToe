package com.game.tictactoe.model;

import com.game.tictactoe.service.PlayStrategy;

/**
 * Created by riham.y.abdelmaksoud on 6/2/2018.
 */
public class Player{
    private char symbol;
    private int next;
    private PlayStrategy playStrategy;

    public Player(char symbol,int next) {
        this.symbol = symbol;
        this.next = next;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public PlayStrategy getPlayStrategy() {
        return playStrategy;
    }

    public void setPlayStrategy(PlayStrategy playStrategy) {
        this.playStrategy = playStrategy;
    }
}
