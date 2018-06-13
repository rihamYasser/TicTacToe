package com.game.tictactoe;

import com.game.tictactoe.model.Game;

/**
 * Created by riham.y.abdelmaksoud on 6/12/2018.
 */
public class GameFactory {

    public static Game createPlayBoard(){
        return GameConfiguration.configure();
    }

}
