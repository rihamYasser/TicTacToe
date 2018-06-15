package com.game.tictactoe;

import com.game.tictactoe.model.Game;
import com.game.tictactoe.model.Player;
import com.game.tictactoe.model.Position;
import com.game.tictactoe.service.ComputerEasyPlayStrategy;
import com.game.tictactoe.service.FullLineWinChecker;
import com.game.tictactoe.service.HumanPlayStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by riham.y.abdelmaksoud on 6/15/2018.
 */
public class FullLineWinCheckerTest {
    FullLineWinChecker fullLineWinChecker = new FullLineWinChecker();

    @Test
    public void checkNoWinForFirstPlay(){
        Game game = new Game(3);

        Position position = new Position(1,1);
        Assert.assertFalse(fullLineWinChecker.checkWinner(game,position,'X'));
    }

    @Test
    public void checkWinInRow(){
        Game game = new Game(3);
        intializePlayers(game);
        game.getGameBoard().markCell(new Position(0,0),'Y');
        game.getGameBoard().markCell(new Position(0,1),'Y');

        //Play Y in the same Row to win
        Position position = new Position(0,2);
        game.getGameBoard().markCell(position,'Y');

        Assert.assertTrue(fullLineWinChecker.checkWinner(game,position,'Y'));
    }

    @Test
    public void checkNoWin(){
        Game game = new Game(3);
        intializePlayers(game);
        game.getGameBoard().markCell(new Position(0,0),'Y');
        game.getGameBoard().markCell(new Position(0,1),'Y');

        //Play Y in the same Row to win
        Position position = new Position(1,1);
        game.getGameBoard().markCell(position,'Y');

        Assert.assertFalse(fullLineWinChecker.checkWinner(game,position,'Y'));
    }

    @Test
    public void checkWinInColumn(){
        Game game = new Game(3);
        intializePlayers(game);
        game.getGameBoard().markCell(new Position(0,0),'Y');
        game.getGameBoard().markCell(new Position(1,0),'Y');

        //Play Y in the same Row to win
        Position position = new Position(2,0);
        game.getGameBoard().markCell(position,'Y');

        Assert.assertTrue(fullLineWinChecker.checkWinner(game,position,'Y'));
    }

    @Test
    public void checkWinInDiagonal(){
        Game game = new Game(3);
        intializePlayers(game);
        game.getGameBoard().markCell(new Position(0,0),'Y');
        game.getGameBoard().markCell(new Position(1,1),'Y');

        //Play Y in the same Row to win
        Position position = new Position(2,2);
        game.getGameBoard().markCell(position,'Y');

        Assert.assertTrue(fullLineWinChecker.checkWinner(game,position,'Y'));
    }

    @Test
    public void checkWinInReverseDiagonal(){
        Game game = new Game(3);
        intializePlayers(game);
        game.getGameBoard().markCell(new Position(0,2),'Y');
        game.getGameBoard().markCell(new Position(1,1),'Y');

        //Play Y in the same Row to win
        Position position = new Position(2,0);
        game.getGameBoard().markCell(position,'Y');

        Assert.assertTrue(fullLineWinChecker.checkWinner(game,position,'Y'));
    }

    private void intializePlayers(Game game){
        Player player1 = new Player('X', 1) ;
        player1.setPlayStrategy(new HumanPlayStrategy());
        Player player2 = new Player('Y',2);
        player2.setPlayStrategy(new ComputerEasyPlayStrategy());
        game.setPlayers(Arrays.asList(player1,player2));
    }

}
