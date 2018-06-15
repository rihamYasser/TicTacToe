package com.game.tictactoe.service;

import com.game.tictactoe.model.Board;
import com.game.tictactoe.model.Game;
import com.game.tictactoe.model.TwoDimensionalBoard;
import com.game.tictactoe.model.Position;

import java.util.Optional;

/**
 * Created by riham.y.abdelmaksoud on 6/13/2018.
 */
public class ComputerEasyPlayStrategy implements PlayStrategy {

    @Override
    public Position play(Game game, char symbol) {
        if(game.getGameBoard().isFull()){
            throw new RuntimeException("Unexpected error occurred please try again! No Free Position for computer to play :(");
        }
        try {
            return winOrBlockHorizontal(game.getGameBoard()).orElseGet(() -> winOrBlockVertical(game.getGameBoard()).orElseGet(()
                    -> (winOrBlockDiagonal
                    (game.getGameBoard())
                    .orElseGet
                            (() -> winOrBlockReverseDiagonal(game.getGameBoard()).orElse(game.getGameBoard().getFirstFreePosition().get())))));
        }catch (Exception ex){
           throw new RuntimeException("Unexpected error occurred please try again!");
        }
    }

    public Optional<Position> winOrBlockHorizontal(Board board) {
        Optional<Position> position ;
        for (int i = 0; i < board.getSize(); i++) { //loop on rows
            position = getWinOrBlockPosition(board, i,true);
            if (position.isPresent()){
                return position;
            }
        }
        return Optional.empty();
    }

    public Optional<Position> winOrBlockVertical(Board board) {
        Optional<Position> position;
        for (int i = 0; i < board.getSize(); i++) { //loop on columns
            position = getWinOrBlockPosition(board, i, false);
            if (position.isPresent()){
                return position;
            }
        }

        return Optional.empty();
    }
    private Optional<Position> getWinOrBlockPosition(Board board, int rowCol, boolean horizontal) {
        int selected = -1;
        int counter = 0;
        char first =board.getCellValue(horizontal?rowCol:0,horizontal?0:rowCol);
        for (int j = 0; j < board.getSize(); j++) { //loop on rows or columns depending on horizontal flag
            if (board.isEmptyPosition(horizontal?rowCol:j, horizontal?j:rowCol)) {
                selected = j;
            } else if (first == TwoDimensionalBoard.EMPTY){
                first = board.getCellValue(horizontal?rowCol:j,horizontal?j:rowCol);
                counter++;
            }
            else if (board.getCellValue(horizontal?rowCol:j,horizontal?j:rowCol) !=
                    first) { //different symbol occurs, so skip iteration
                break;
            } else {//Same symbol so increment counter
                counter++;
            }
        }
        if (selected!= -1 && counter == board.getSize() - 1) {
            return Optional.of(new Position(horizontal?rowCol:selected,horizontal?selected:rowCol));
        }
        return Optional.empty();
    }

    public Optional<Position> winOrBlockDiagonal(Board board) {
        int index = -1;
        int diagonalCellsCounter = 0;
        char firstSymbolInDiagonal =board.getCellValue(0,0);
        for (int i = 0; i < board.getSize(); i++) {
            if (board.isEmptyPosition(i, i)) {
                index = i;
            } else if(firstSymbolInDiagonal == TwoDimensionalBoard.EMPTY){
                firstSymbolInDiagonal = board.getCellValue(i,i);
                diagonalCellsCounter++;
            }else if (board.getCellValue(i,i) != firstSymbolInDiagonal) {
                break;
            } else {
                diagonalCellsCounter++;
            }
        }
        if (index != -1 && diagonalCellsCounter == board.getSize() - 1) {
            return Optional.of(new Position(index,index));
        }


        return Optional.empty();
    }
    public Optional<Position> winOrBlockReverseDiagonal(Board board) {

        int selectedRow = -1, selectedCol =-1;
        int row = 0;
        int col = board.getSize()-1;
        int diagonalCellsCounter = 0;
        char firstSymbolInReversDiagonal = board.getCellValue(row,col);
        for (int i = 0; i < board.getSize(); i++) {

            if (board.isEmptyPosition(row, col)) {
                selectedRow = row;
                selectedCol = col;
            } else if(firstSymbolInReversDiagonal == TwoDimensionalBoard.EMPTY){
                firstSymbolInReversDiagonal = board.getCellValue(row,col);
                diagonalCellsCounter++;
            } else if (board.getCellValue(row,col) != firstSymbolInReversDiagonal) {
                break;
            } else {
                diagonalCellsCounter++;
            }
            row = row+1;
            col= col-1;
        }
        if (selectedRow!= -1 && selectedCol!= -1 && diagonalCellsCounter == board.getSize() - 1) {
            return Optional.of(new Position(selectedRow,selectedCol));
        }
        return Optional.empty();
    }
}
