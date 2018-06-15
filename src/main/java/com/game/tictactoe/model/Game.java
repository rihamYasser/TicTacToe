package com.game.tictactoe.model;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Created by riham.y.abdelmaksoud on 6/2/2018.
 */
public class Game  {
    private Board gameBoard;
    private List<Player> players;
    private Optional<Player> winner;

    public Game() {

    }

    public Game(int size) {
        gameBoard = new TwoDimensionalBoard(size);
    }

    public void markBoard(Position position, Player player) {
        gameBoard.validatePosition(position);
        gameBoard.markCell(position, player.getSymbol());
        gameBoard.print();
    }

    public int getFirstPlayerNumber() {
        Random rn = new Random();
        return rn.nextInt(2);
    }

    public boolean isGameOver(){
        return gameBoard.isFull() ;
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

    public Board getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Optional<Player> getWinner() {
        return winner;
    }

    public void setWinner(Optional<Player> winner) {
        this.winner = winner;
    }

}
