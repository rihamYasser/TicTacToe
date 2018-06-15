package com.game.tictactoe.service;

import com.game.tictactoe.model.Game;
import com.game.tictactoe.model.GameBoard;
import com.game.tictactoe.model.Position;

import java.util.Optional;

/**
 * Created by riham.y.abdelmaksoud on 6/13/2018.
 Implementation of WinChecker by checking that the whole horizontal, vertical, or Diagonal line is marked
 */

public class FullLineWinChecker implements WinChecker{

    @Override
    public Boolean checkWinner(Game game, Position lastPosition, char symbol) {

        boolean win = checkHorizontal(game.getGameBoard(),lastPosition.getRow(),symbol)
                || checkVertical(game.getGameBoard(), lastPosition.getColumn(),symbol)
                || checkReverseDiagonal(game.getGameBoard(),symbol)
                || checkDiagonal(game.getGameBoard(),symbol);

        if(win){
            game.setWinner(game.getPlayer(symbol));
            return true;
        }
        game.setWinner(Optional.empty());
        return false;
    }

    private boolean checkDiagonal(GameBoard board, char symbol) {
        boolean win =false;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard()[i][i] != symbol) {
               return false;
            }
            win = true;
        }
        return win;
    }

    private boolean checkReverseDiagonal(GameBoard board, char symbol) {
        int row = 0;
        int col = board.getSize()-1;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard()[row][col] != symbol) {
                return false;
            }
            row = row+1;
            col= col-1;
        }
        return true;
    }

    private boolean checkVertical(GameBoard board, int col, char symbol) {
        boolean win =false;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard()[i][col] != symbol) {
                return false;
            }
            win = true;
        }
        return win;
    }

    private boolean checkHorizontal(GameBoard board, int row, char symbol) {
        boolean win =false;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard()[row][i] != symbol) {
                return false;
            }
            win = true;
        }
        return win;
    }
}
