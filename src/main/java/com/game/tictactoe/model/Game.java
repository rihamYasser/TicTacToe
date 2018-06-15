package com.game.tictactoe.model;

import com.game.tictactoe.service.Printable;

import java.util.List;
import java.util.Optional;

/**
 * Created by riham.y.abdelmaksoud on 6/2/2018.
 */
public class Game implements Printable {
    private GameBoard gameBoard;
    private List<Player> players;
    private Optional<Player> winner;

    public Game() {

    }

    public Game(int size) {
        gameBoard = new GameBoard(size);
    }

    public void markBoard(Position position, Player player) {
        validatePosition(position);
        gameBoard.getBoard()[position.getRow()][position.getColumn()] = player.getSymbol();
        print();
    }

    private void validatePosition(Position position) {
        if(gameBoard.isOutOfBound(position)){
            throw new IllegalArgumentException("Position is out of range");
        }
        if(!gameBoard.isEmptyPosition(position.getRow(),position.getColumn())){
            throw new IllegalArgumentException("Position is already marked");
        }
    }

    @Override
    public void print() {
        for( int row =0;row< gameBoard.getSize();row++) {
            for (int col =0;col< gameBoard.getSize();col++) {
                System.out.print(gameBoard.getBoard()[row][col]);
                if(col != gameBoard.getSize()-1){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    public boolean isGameOver(){
        return gameBoard.isFull();
    }

    public Optional<Player> getPlayer(char symbol){
        for (Player player:this.players){
            if(player.getSymbol() == symbol){
                return Optional.of(player);
            }
        }
        return Optional.empty();
    }
    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Optional<Player> getWinner() {
        return winner;
    }

    public void setWinner(Optional<Player> winner) {
        this.winner = winner;
    }
}
