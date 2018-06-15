package com.game.tictactoe.exception;

/**
 * Created by riham.y.abdelmaksoud on 6/15/2018.
 */
public class InvalidInputException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public InvalidInputException(String string) {
        super(string);
    }
}
