package com.game.tictactoe;

import com.game.tictactoe.model.ComputerPlayer;
import com.game.tictactoe.model.HumanPlayer;
import com.game.tictactoe.model.Game;
import com.game.tictactoe.model.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by riham.y.abdelmaksoud on 6/12/2018.
 */
public class GameConfiguration {

    private static final String CONFIG_FILE_NAME = "game";
    private static final String PLAY_BOARD_SIZE_PROPERTY = "game.size";
    private static final String PLAYER_1_SYMBOL_PROPERTY = "player1.symbol";
    private static final String PLAYER_2_SYMBOL_PROPERTY = "player2.symbol";
    private static final String PLAYER_COMPUTER_SYMBOL_PROPERTY = "computer.symbol";
    private static final int PLAY_BOARD_DEFAULT_SIZE = 3;
    private static final int PLAYER_CHARACTER_LINE_NUM = 1;

    //TODO check better static loading?
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(CONFIG_FILE_NAME);

    public static Game configure(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(CONFIG_FILE_NAME);
        Game board = new Game(readSize());
        board.setPlayers(initializePlayers());
        return board;

    }

    public static List<Player> initializePlayers(){

        String player1Symbol = resourceBundle.getString(PLAYER_1_SYMBOL_PROPERTY);
        if(player1Symbol == null || player1Symbol.length() == 0 ){
            throw new IllegalArgumentException("Missing Player1 symbol property");
        }

        String player2Symbol = resourceBundle.getString(PLAYER_2_SYMBOL_PROPERTY);
        if(player2Symbol == null || player2Symbol.length() == 0 ){
            throw new IllegalArgumentException("Missing Player2 symbol property");
        }
        if(player2Symbol.equals(player1Symbol)){
            throw new IllegalArgumentException("Please configure different symbol for each player");
        }

        String computerSymbol = resourceBundle.getString(PLAYER_COMPUTER_SYMBOL_PROPERTY);
        if(computerSymbol == null || computerSymbol.length() == 0 ){
            throw new IllegalArgumentException("Missing Computer symbol property");
        }
        if(computerSymbol.equals(player1Symbol) || computerSymbol.equals(player2Symbol) ){
            throw new IllegalArgumentException("Please configure different symbol for each player");
        }

        return Collections.unmodifiableList(Arrays.asList(new HumanPlayer(0,player1Symbol.charAt(0),1),
                new HumanPlayer(1,player2Symbol.charAt(0),0)/*,new ComputerPlayer(2,computerSymbol.charAt(0),0)*/));
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
