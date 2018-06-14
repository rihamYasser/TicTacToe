package com.game.tictactoe.model;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by riham.y.abdelmaksoud on 6/13/2018.
 */
public class GameBoard {
    public static final char EMPTY = '-';
    private char[][] board;
    private int size;

    public GameBoard(int size) {
        this.size = size;
        board = new char[size][size];
        for(int x=0;x<board.length;x++)
            Arrays.fill( board[x], GameBoard.EMPTY );
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmptyPosition(int row, int col){
        return this.board[row][col] == EMPTY;
    }
    public boolean isOutOfBound(Position position){
        return position.getRow() <0 || position.getRow() >= this.size
                || position.getColumn()< 0 || position.getColumn() >= this.size;
    }

}
