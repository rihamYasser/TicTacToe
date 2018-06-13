package com.game.tictactoe.model;

/**
 * Created by riham.y.abdelmaksoud on 6/12/2018.
 */
public class ComputerPlayer extends Player{

    public ComputerPlayer(int index, char symbol,int next){
        super ( index,  symbol, next);
    }

    @Override
    public Position play() {
        return new Position(0,0);
    }
}
