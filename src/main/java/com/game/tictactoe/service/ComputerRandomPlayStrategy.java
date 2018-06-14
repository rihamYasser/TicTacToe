package com.game.tictactoe.service;

import com.game.tictactoe.model.GameBoard;
import com.game.tictactoe.model.Position;

import java.util.Random;

/**
 * Created by riham.y.abdelmaksoud on 6/13/2018.
 */
public class ComputerRandomPlayStrategy implements PlayStrategy {

    @Override
    public Position play(GameBoard board, char symbol) {
        Random rowRandom = new Random(board.getSize()-1);
        Random colRandom = new Random(board.getSize()-1);
        int row = rowRandom.nextInt();
        int col = colRandom.nextInt();
        while(!board.isEmptyPosition(row,col)){
            row = rowRandom.nextInt();
            col = colRandom.nextInt();
        }
//        int move = (int)(Math.random()*board.getSize()*board.getSize());
//        while(board.getBoard()[move/board.getSize()][move%board.getSize()] != GameBoard.EMPTY) {
//            move = (int) (Math.random() * (board.getSize()*board.getSize()));
//        }
//
        return  new Position(col,row) ;

    }
}
