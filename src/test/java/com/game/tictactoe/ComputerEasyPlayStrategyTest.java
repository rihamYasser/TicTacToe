package com.game.tictactoe;

import com.game.tictactoe.model.Board;
import com.game.tictactoe.model.Game;
import com.game.tictactoe.model.Position;
import com.game.tictactoe.model.TwoDimensionalBoard;
import com.game.tictactoe.service.ComputerSimplePlayStrategy;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by riham.y.abdelmaksoud on 6/15/2018.
 */
public class ComputerEasyPlayStrategyTest {

    ComputerSimplePlayStrategy easyPlayStrategy = new ComputerSimplePlayStrategy();

    @Test
    public void playTest(){
        Game game = new Game(3);
        game.getGameBoard().markCell(new Position(0,0),'X');
        game.getGameBoard().markCell(new Position(0,1),'X');

        Assert.assertEquals(easyPlayStrategy.play(game,'Z').getRow(),0);
        Assert.assertEquals(easyPlayStrategy.play(game,'Z').getColumn(),2);

        game.getGameBoard().markCell(new Position(0,2),'Z');
        game.getGameBoard().markCell(new Position(1,1),'X');
        Assert.assertEquals(easyPlayStrategy.play(game,'Z').getRow(),2);
        Assert.assertEquals(easyPlayStrategy.play(game,'Z').getColumn(),1);
    }

    @Test
    public void winOrBlockHorizontalTest() {
        Board board = new TwoDimensionalBoard(3);
        board.markCell(new Position(0,0),'X');
        board.markCell(new Position(0,1),'X');

        Assert.assertTrue(easyPlayStrategy.winOrBlockHorizontal(board).isPresent());
        Assert.assertEquals(easyPlayStrategy.winOrBlockHorizontal(board).get().getRow(),0);
        Assert.assertEquals(easyPlayStrategy.winOrBlockHorizontal(board).get().getColumn(),2);
    }

    @Test
    public void winOrBlockVerticalTest() {
        Board board = new TwoDimensionalBoard(3);
        board.markCell(new Position(0,0),'Z');
        board.markCell(new Position(2,0),'Z');
        Assert.assertTrue(easyPlayStrategy.winOrBlockVertical(board).isPresent());
        Assert.assertEquals(easyPlayStrategy.winOrBlockVertical(board).get().getRow(),1);
        Assert.assertEquals(easyPlayStrategy.winOrBlockVertical(board).get().getColumn(),0);
    }

    @Test
    public void winOrBlockDiagonalTest() {
        Board board = new TwoDimensionalBoard(3);
        board.markCell(new Position(0,0),'Z');
        board.markCell(new Position(2,2),'Z');
        Assert.assertTrue(easyPlayStrategy.winOrBlockDiagonal(board).isPresent());
        Assert.assertEquals(easyPlayStrategy.winOrBlockDiagonal(board).get().getRow(),1);
        Assert.assertEquals(easyPlayStrategy.winOrBlockDiagonal(board).get().getColumn(),1);
    }

    @Test
    public void winOrBlockReverseDiagonalTest() {
        Board board = new TwoDimensionalBoard(3);
        board.markCell(new Position(2,0),'X');
        board.markCell(new Position(1,1),'X');
        Assert.assertTrue(easyPlayStrategy.winOrBlockReverseDiagonal(board).isPresent());
        Assert.assertEquals(easyPlayStrategy.winOrBlockReverseDiagonal(board).get().getRow(),0);
        Assert.assertEquals(easyPlayStrategy.winOrBlockReverseDiagonal(board).get().getColumn(),2);

    }
}
