package com.game.tictactoe.model;

/**
 * Created by riham.y.abdelmaksoud on 6/12/2018.
 */
public class Position {
    private int row;
    private int column;
    private boolean best;

    public Position(int row,int column){
        this.row = row;
        this.column = column;
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isBest() {
        return best;
    }

    public void setBest(boolean best) {
        this.best = best;
    }
}
