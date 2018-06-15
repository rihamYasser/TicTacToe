package com.game.tictactoe.service;

import com.game.tictactoe.model.Game;
import com.game.tictactoe.model.Player;
import com.game.tictactoe.model.Position;

/**
 * Created by riham.y.abdelmaksoud on 6/12/2018.
 */
public class TicTacToeGameService implements GameService {

    private WinChecker winChecker;

    public TicTacToeGameService(){
        winChecker = new FullLineWinChecker();
    }
    @Override
    public void startGame(Game game){

        game.getGameBoard().print();

        int firstPlayer = game.getFirstPlayerNumber();

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

    public WinChecker getWinChecker() {
        return winChecker;
    }

    public void setWinChecker(WinChecker winChecker) {
        this.winChecker = winChecker;
    }
}
