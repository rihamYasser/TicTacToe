package com.game.tictactoe.service;

import com.game.tictactoe.model.Game;
import com.game.tictactoe.model.GameBoard;
import com.game.tictactoe.model.Position;

/**
 * Created by riham.y.abdelmaksoud on 6/13/2018.
 Implementation of WinChecker by checking that the whole horizontal, vertical, or Diagonal line is marked
 */

public class FullLineWinChecker implements WinChecker{

    @Override
    public Boolean checkWinner(GameBoard board, Position lastPosition, char symbol) {

        if(checkHorizontal(board,lastPosition.getRow(),symbol)){
            return true;
        }

        if(checkVertical(board, lastPosition.getColumn(),symbol)){
            return true;
        }
        if (lastPosition.getColumn() == lastPosition.getRow()) {
            return checkDiagonal(board,symbol);

        }
        return false;
    }

    private boolean checkDiagonal(GameBoard board, char symbol) {
        boolean win =false;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard()[i][i] != symbol) {
                win = false;
                break;
            }
            win = true;
        }
        return win;
    }

    private boolean checkVertical(GameBoard board, int col, char symbol) {
        boolean win =false;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard()[i][col] != symbol) {
                win = false;
                break;
            }
            win = true;
        }
        return win;
    }

    private boolean checkHorizontal(GameBoard board, int row, char symbol) {
        boolean win =false;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard()[row][i] != symbol) {
                win = false;
                break;
            }
            win = true;
        }
        return win;
    }
}
