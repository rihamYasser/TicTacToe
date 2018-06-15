package com.game.tictactoe.model;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by riham.y.abdelmaksoud on 6/13/2018.
 */
public class TwoDimensionalBoard implements Board {
    private char[][] cells;
    private int size;

    public TwoDimensionalBoard(int size) {
        this.size = size;
        cells = new char[size][size];
        for(int x = 0; x< cells.length; x++) {
            Arrays.fill(cells[x], EMPTY);
        }
    }

    public char[][] getCells() {
        return cells;
    }

    public void setCells(char[][] cells) {
        this.cells = cells;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean isEmptyPosition(int row, int col){
        return this.cells[row][col] == EMPTY;
    }

    @Override
    public boolean isOutOfBound(Position position){
        return position.getRow() <0 || position.getRow() >= this.size
                || position.getColumn()< 0 || position.getColumn() >= this.size;
    }
    @Override
    public Optional<Position> getFirstFreePosition(){
        for (int i =0; i<size ;i++){
            for (int j =0; j<size ;j++){
                if(isEmptyPosition(i,j)){
                    return Optional.of(new Position(i,j));
                }
            }
        }
        return Optional.empty();
    }
    @Override
    public boolean isFull(){
        for (int i =0; i<size ;i++){
            for (int j =0; j<size ;j++){
                if(isEmptyPosition(i,j)){
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public void validatePosition(Position position) {
        if(isOutOfBound(position)){
            throw new IllegalArgumentException("Position is out of range");
        }
        if(!isEmptyPosition(position.getRow(),position.getColumn())){
            throw new IllegalArgumentException("Position is already marked");
        }
    }

    @Override
    public void markCell(Position position, char symbol) {
        cells[position.getRow()][position.getColumn()]  =symbol;
    }

    @Override
    public char getCellValue(int row, int col) {
        return cells[row][col];
    }

    @Override
    public void print() {
        for( int row =0;row< getSize();row++) {
            for (int col =0;col< getSize();col++) {
                System.out.print(getCells()[row][col]);
                if(col != getSize()-1){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

}
