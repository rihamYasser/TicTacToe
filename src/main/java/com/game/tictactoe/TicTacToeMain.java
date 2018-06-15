package com.game.tictactoe;

import com.game.tictactoe.model.Game;
import com.game.tictactoe.service.FullLineWinChecker;
import com.game.tictactoe.service.GameService;
import com.game.tictactoe.service.TicTacToeGameService;

public class TicTacToeMain {


    public static void main(String[] args) {
        Game game = GameFactory.createTicTacToeGame();
        GameService gameManager = new TicTacToeGameService();
        gameManager.startGame(game);
    }

}
