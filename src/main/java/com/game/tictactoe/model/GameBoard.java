package com.game.tictactoe.model;

import java.util.Arrays;

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
}
