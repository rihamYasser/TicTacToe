package com.game.tictactoe.model;
/**
 * Created by riham.y.abdelmaksoud on 6/2/2018.
 */
public abstract class Player implements Playing{
    private int number;
    private char symbol;
    private boolean win;
    private int nextPlayerNumber;

    public Player(int index, char symbol,int next) {
        this.number = index;
        this.symbol = symbol;
        this.nextPlayerNumber = next;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNextPlayerNumber() {
        return nextPlayerNumber;
    }

    public void setNextPlayerNumber(int nextPlayerNumber) {
        this.nextPlayerNumber = nextPlayerNumber;
    }
}
