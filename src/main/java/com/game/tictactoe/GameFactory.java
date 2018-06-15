package com.game.tictactoe;

import com.game.tictactoe.exception.InvalidConfigurationException;
import com.game.tictactoe.model.Game;
import com.game.tictactoe.model.Player;
import com.game.tictactoe.service.ComputerSimplePlayStrategy;
import com.game.tictactoe.service.HumanPlayStrategy;
import com.game.tictactoe.util.ResourceBundles;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by riham.y.abdelmaksoud on 6/12/2018.
 * Tic-Tac-Toe Game Factory
 */
public class GameFactory {

    private static final String CONFIG_FILE_NAME = "game";
    private static final String PLAY_BOARD_SIZE_PROPERTY = "game.size";
    private static final String PLAYER_1_SYMBOL_PROPERTY = "player1.symbol";
    private static final String PLAYER_2_SYMBOL_PROPERTY = "player2.symbol";
    private static final String PLAYER_COMPUTER_SYMBOL_PROPERTY = "computer.symbol";
    private static final int PLAY_BOARD_DEFAULT_SIZE = 3;

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(
            ResourceBundles.CONFIG.getBundleName());


    public static Game createTicTacToeGame(){
        Game game = new Game(readSize());
        game.setPlayers(initializePlayers());
        return game;
    }

    public static List<Player> initializePlayers(){

        String player1Symbol = resourceBundle.getString(PLAYER_1_SYMBOL_PROPERTY);
        if(player1Symbol == null || player1Symbol.length() == 0 ){
            throw new InvalidConfigurationException("Missing Player1 symbol property");
        }

        String player2Symbol = resourceBundle.getString(PLAYER_2_SYMBOL_PROPERTY);
        if(player2Symbol == null || player2Symbol.length() == 0 ){
            throw new InvalidConfigurationException("Missing Player2 symbol property");
        }
        if(player2Symbol.equals(player1Symbol)){
            throw new InvalidConfigurationException("Please configure different symbol for each player");
        }

        String computerSymbol = resourceBundle.getString(PLAYER_COMPUTER_SYMBOL_PROPERTY);
        if(computerSymbol == null || computerSymbol.length() == 0 ){
            throw new InvalidConfigurationException("Missing Computer symbol property");
        }
        if(computerSymbol.equals(player1Symbol) || computerSymbol.equals(player2Symbol) ){
            throw new InvalidConfigurationException("Please configure different symbol for each player");
        }
        Player player1 = new Player(player1Symbol.charAt(0), 1) ;
        player1.setPlayStrategy(new HumanPlayStrategy());
        Player player2 = new Player(player2Symbol.charAt(0),2);
        player2.setPlayStrategy(new HumanPlayStrategy());
        Player computer = new Player(computerSymbol.charAt(0), 0) ;
        computer.setPlayStrategy(new ComputerSimplePlayStrategy());

        return Arrays.asList(player1,player2,computer);
    }

    private static int readSize(){
        try{
            return Integer.parseInt(resourceBundle.getString(PLAY_BOARD_SIZE_PROPERTY));
        }
        catch (NumberFormatException ex){
            System.out.println("Invalid play board size value");
        }
        return PLAY_BOARD_DEFAULT_SIZE;
    }

}
