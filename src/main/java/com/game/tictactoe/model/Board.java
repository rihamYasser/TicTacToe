package com.game.tictactoe.model;

import com.game.tictactoe.model.Position;

import java.util.Optional;

/**
 * Created by riham.y.abdelmaksoud on 6/15/2018.
 */
public interface Board {
    char EMPTY = '-';
    void print();
    boolean isEmptyPosition(int row, int col);
    char getCellValue(int row, int col);
    boolean isOutOfBound(Position position);
    Optional<Position> getFirstFreePosition();
    boolean isFull();
    void validatePosition(Position position) ;
    void markCell(Position position,char symbol);
    int getSize();
}
