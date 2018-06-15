package com.game.tictactoe.exception;

/**
 * Created by riham.y.abdelmaksoud on 6/15/2018.
 */
public class InvalidBoardPositionException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public InvalidBoardPositionException(String string) {
        super(string);
    }
}
