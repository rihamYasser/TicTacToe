package com.game.tictactoe.service;

import com.game.tictactoe.model.GameBoard;
import com.game.tictactoe.model.Position;

/**
 * Created by riham.y.abdelmaksoud on 6/13/2018.
 */
public class ComputerRandomPlayStrategy implements PlayStrategy {

    @Override
    public Position play(GameBoard board, char symbol) {
        int move = (int)(Math.random()*board.getSize()*board.getSize());
        while(board.getBoard()[move/board.getSize()][move%board.getSize()] != GameBoard.EMPTY) {
            move = (int) (Math.random() * (board.getSize()*board.getSize()));
        }

        return  new Position((int)(move/3),move%3) ;

    }
}
