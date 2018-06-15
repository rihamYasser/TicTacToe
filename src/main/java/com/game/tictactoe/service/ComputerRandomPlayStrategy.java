package com.game.tictactoe.service;

import com.game.tictactoe.model.Game;
import com.game.tictactoe.model.Position;

import java.util.Optional;

/**
 * Created by riham.y.abdelmaksoud on 6/13/2018.
 */
public class ComputerRandomPlayStrategy implements PlayStrategy {

    @Override
    public Position play(Game game, char symbol) {
        Optional<Position> position = game.getGameBoard().getFirstFreePosition();
        if(position.isPresent()) {
            return position.get();
        } else {
            throw new
                    RuntimeException("Unexpected error occurred please try again! No " +
                    "Free " +
                    "Position for " +
                    "computer to play :(");
        }
    }
}
