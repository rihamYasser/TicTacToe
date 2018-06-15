package com.game.tictactoe.service;

import com.game.tictactoe.model.Game;
import com.game.tictactoe.model.GameBoard;
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
            return winOrPreventHorizontal(game.getGameBoard()).orElseGet(() -> winOrPreventVertical(game.getGameBoard()).orElseGet(()
                    -> (winOrPreventDiagonal
                    (game.getGameBoard())
                    .orElseGet
                            (() -> winOrPreventReverseDiagonal(game.getGameBoard()).orElse(game.getGameBoard().getFirstFreePosition().get())))));
        }catch (Exception ex){
           throw new RuntimeException("Unexpected error occurred please try again!");
        }
    }

    public Optional<Position> winOrPreventHorizontal(GameBoard board) {
        Optional<Position> position ;
        for (int i = 0; i < board.getSize(); i++) { //loop on rows
            position = getWinOrPreventPosition(board, i,true);
            if (position.isPresent()){
                return position;
            }
        }
        return Optional.empty();
    }

    public Optional<Position> winOrPreventVertical(GameBoard board) {
        Optional<Position> position;
        for (int i = 0; i < board.getSize(); i++) { //loop on columns
            position = getWinOrPreventPosition(board, i, false);
            if (position.isPresent()){
                return position;
            }
        }

        return Optional.empty();
    }
    private Optional<Position> getWinOrPreventPosition(GameBoard board, int rowCol, boolean horizontal) {
        int selected = -1;
        int counter = 0;
        char first =board.getBoard()[horizontal?rowCol:0][horizontal?0:rowCol];
        for (int j = 0; j < board.getSize(); j++) { //loop on rows or columns depending on horizontal flag
            if (board.isEmptyPosition(horizontal?rowCol:j, horizontal?j:rowCol)) {
                selected = j;
            } else if (first == GameBoard.EMPTY){
                first = board.getBoard()[horizontal?rowCol:j][horizontal?j:rowCol];
                counter++;
            }
            else if (board.getBoard()[horizontal?rowCol:j][horizontal?j:rowCol] !=
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

    public Optional<Position> winOrPreventDiagonal(GameBoard board) {
        int index = -1;
        int diagonalCellsCounter = 0;
        char firstSymbolInDiagonal =board.getBoard()[0][0];
        for (int i = 0; i < board.getSize(); i++) {
            if (board.isEmptyPosition(i, i)) {
                index = i;
            } else if(firstSymbolInDiagonal == GameBoard.EMPTY){
                firstSymbolInDiagonal = board.getBoard()[i][i];
                diagonalCellsCounter++;
            }else if (board.getBoard()[i][i] != firstSymbolInDiagonal) {
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
    public Optional<Position> winOrPreventReverseDiagonal(GameBoard board) {

        int selectedRow = -1, selectedCol =-1;
        int row = 0;
        int col = board.getSize()-1;
        int diagonalCellsCounter = 0;
        char firstSymbolInReversDiagonal = board.getBoard()[row][col];
        for (int i = 0; i < board.getSize(); i++) {

            if (board.isEmptyPosition(row, col)) {
                selectedRow = row;
                selectedCol = col;
            } else if(firstSymbolInReversDiagonal == GameBoard.EMPTY){
                firstSymbolInReversDiagonal = board.getBoard()[row][col];
                diagonalCellsCounter++;
            } else if (board.getBoard()[row][col] != firstSymbolInReversDiagonal) {
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


    public static void main(String[] args){
        ComputerEasyPlayStrategy c = new ComputerEasyPlayStrategy();
        Game game = new Game(3);
        game.getGameBoard().getBoard()[1][0]= 'X';
        game.getGameBoard().getBoard()[1][0]= 'X';
//        board.getBoard()[0][2]= '-';
//        board.getBoard()[1][0]= '-';
//        board.getBoard()[1][1]= 'X';
//        board.getBoard()[1][2]= 'X';
//        board.getBoard()[2][0]= '-';
//        board.getBoard()[2][1]= '-';
//        board.getBoard()[2][2]= '-';
        Position p = c.play(game,'A');
        System.out.print(p.getRow());
        System.out.print(p.getColumn());
    }

}
