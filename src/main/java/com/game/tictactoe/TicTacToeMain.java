package com.game.tictactoe;

import com.game.tictactoe.model.Game;
import com.game.tictactoe.model.Player;
import com.game.tictactoe.service.GameManager;

import java.util.Scanner;

public class TicTacToeMain {


    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.startGame();
    }

}
