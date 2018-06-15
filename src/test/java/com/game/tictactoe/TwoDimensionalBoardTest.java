package com.game.tictactoe;

import com.game.tictactoe.exception.InvalidBoardPositionException;
import com.game.tictactoe.model.Board;
import com.game.tictactoe.model.Position;
import com.game.tictactoe.model.TwoDimensionalBoard;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by riham.y.abdelmaksoud on 6/15/2018.
 */

public class TwoDimensionalBoardTest {

    public static final int SIZE = 3;

    @Test
    public void testGetSize(){
        TwoDimensionalBoard board = new TwoDimensionalBoard(SIZE);
        int size = board.getSize();
        Assert.assertEquals(size, SIZE);
    }

    @Test
    public void isEmptyPositionTest(){
        TwoDimensionalBoard board = new TwoDimensionalBoard(SIZE);
        for (int i=0;i<SIZE; i++){
            for(int j=0; j<SIZE ;j++){
                Assert.assertTrue(board.isEmptyPosition(i,j));
            }
        }
    }

    @Test
    public void isOutOfBoundTest(){
        TwoDimensionalBoard board = new TwoDimensionalBoard(SIZE);
        Assert.assertTrue(board.isOutOfBound(new Position(4,4)));
        Assert.assertTrue(board.isOutOfBound(new Position(4,-1)));
        Assert.assertTrue(board.isOutOfBound(new Position(-1,2)));
        Assert.assertTrue(board.isOutOfBound(new Position(-1,-1)));
        Assert.assertFalse(board.isOutOfBound(new Position(0,0)));
        Assert.assertFalse(board.isOutOfBound(new Position(2,2)));
    }

    @Test
    public void getFirstFreePositionTest() {
        TwoDimensionalBoard board = new TwoDimensionalBoard(SIZE);
        for (int x = 0; x < board.getCells().length; x++){

            Arrays.fill(board.getCells()[x], 'X');
        }
        Assert.assertFalse(board.getFirstFreePosition().isPresent());

        board.getCells()[1][2] = Board.EMPTY;
        Assert.assertTrue(board.getFirstFreePosition().isPresent());
        Assert.assertEquals(board.getFirstFreePosition().get().getColumn(),2);
        Assert.assertEquals(board.getFirstFreePosition().get().getRow(),1);

    }

    @Test
    public void isFullTest() {
        TwoDimensionalBoard board = new TwoDimensionalBoard(SIZE);
        Assert.assertFalse(board.isFull());
        for (int x = 0; x < board.getCells().length; x++){

            Arrays.fill(board.getCells()[x], 'X');
        }
        Assert.assertTrue(board.isFull());
    }

    @Test(expected = InvalidBoardPositionException.class)
    public void validatePositionForNonEmptyCellTest() {
        TwoDimensionalBoard board = new TwoDimensionalBoard(SIZE);
        board.getCells()[1][2] = 'X';
        board.validatePosition(new Position(1,2));
    }

    @Test(expected = InvalidBoardPositionException.class)
    public void validatePositionForOutOfBoundCellTest() {
        TwoDimensionalBoard board = new TwoDimensionalBoard(SIZE);
        board.validatePosition(new Position(5,2));
    }

    @Test
    public void markCellTest() {
        TwoDimensionalBoard board = new TwoDimensionalBoard(SIZE);
        board.markCell(new Position(0,2),'X');
        Assert.assertEquals(board.getCells()[0][2],'X');
    }

    @Test
    public void getCellValueTest() {
        TwoDimensionalBoard board = new TwoDimensionalBoard(SIZE);
        board.getCells()[0][2] = 'Y';
        Assert.assertEquals(board.getCells()[0][2],'Y');
    }

    @Test
    public void printTest() {
        TwoDimensionalBoard board = new TwoDimensionalBoard(SIZE);
        board.print();
    }

}
