package com.game.tictactoe.service;

import com.game.tictactoe.model.Game;
import com.game.tictactoe.model.Position;

/**
 * Created by riham.y.abdelmaksoud on 6/13/2018.
 */
public interface PlayStrategy {

    Position play(Game game , char symbol);
}
