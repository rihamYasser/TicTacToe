package com.game.tictactoe.service;

import com.game.tictactoe.model.GameBoard;
import com.game.tictactoe.model.Position;
import com.game.tictactoe.util.InputScanner;

/**
 * Created by riham.y.abdelmaksoud on 6/13/2018.
 */
public class HumanPlayStrategy implements PlayStrategy {

    public static final String INPUT_SPLITTER = ",";
    @Override
    public Position play(GameBoard board, char symbol) {
        InputScanner.getScanner();
//        System.out.println("Player ["+this.getSymbol()+"] turn");
        String input = InputScanner.getScanner().next();
        return formatInput(input);
    }

    private Position formatInput(String input) {
        String[] indexes = input.split(INPUT_SPLITTER);
        if (indexes.length <= 1) {
            throw new IllegalArgumentException("Please enter a valid position in a format like 3,1");
            // return new Position(-1, -1);
        }
        try {
            return new Position(Integer.parseInt(indexes[0]), Integer.parseInt(indexes[1]));
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Please enter valid row and column numbers");
        }
        //  return new Position(-1, -1);
    }
}
