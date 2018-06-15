package com.game.tictactoe.exception;

/**
 * Created by riham.y.abdelmaksoud on 6/15/2018.
 */
public class InvalidConfigurationException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public InvalidConfigurationException(String string) {
        super(string);
    }
}