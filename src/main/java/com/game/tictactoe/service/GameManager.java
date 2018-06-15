package com.game.tictactoe.service;

import com.game.tictactoe.GameFactory;
import com.game.tictactoe.model.Game;
import com.game.tictactoe.model.Player;
import com.game.tictactoe.model.Position;

import java.util.Random;

/**
 * Created by riham.y.abdelmaksoud on 6/12/2018.
 */
public class GameManager {

    private WinChecker winChecker;

    public void startGame(){
        //inject winCheckerservice , that should be done by configuration later
        winChecker = new FullLineWinChecker();
        Game board = GameFactory.createPlayBoard();
        board.print();
        play(board);
    }


    private int getFirstPlayerNumber() {
        Random rn = new Random();
        return rn.nextInt(2);
    }

    private void play(Game game) {

        int firstPlayer = getFirstPlayerNumber();

        Player currentPlayer = game.getPlayers().get(firstPlayer);
        System.out.println("Player ["+currentPlayer.getSymbol()+"] will start");

        while(!game.isGameOver()) {

            System.out.println("Player ["+currentPlayer.getSymbol()+"] turn");
            try {
                Position position = currentPlayer.getPlayStrategy().play(
                        game,currentPlayer.getSymbol());
                game.markBoard(position,currentPlayer);
                if(winChecker.checkWinner(game,position,currentPlayer.getSymbol())){
                    System.out.println("Player ["+currentPlayer.getSymbol()+"] wins!");
                    break;
                }
            }catch (IllegalArgumentException ex){
                //If there is some thing wrong in the position let the player try again
                System.out.println("Wrong Input!"+ex.getMessage());
                continue;
            }
            currentPlayer = game.getPlayers().get(currentPlayer.getNext());
        }
        if(!game.getWinner().isPresent()) {
            System.out.println("Game Over!");
        }
    }
}
