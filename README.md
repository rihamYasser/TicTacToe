*Tic-Tac-Toe game maven Java8 Application.
*Run com.game.tictactoe.TicTacToeMain class to start the game.

*Current game implementation is for for 3 players, two is Human players and one is Computer
*Other changeable Game configurations are:
    **Game Board size is 3
    **Players symbols are X, Y and Z
*To change game configuration, edit game.properties file

*Computer Play strategy is simple(stupid :)) play strategy, it just blocks other players from winning.

*The player wins if he marks all the row, column, diagonal or cross diagonal.

 *Future Enhancements:
    **Make Play strategy configurable, so that adding new strategy will be done by implementing com.game.tictactoe
    .service
    .PlayStrategy and configure the strategy of each player in game.properties file.
     **Put all messages/errors in messages.properties/errors.properties file so it can be easily configured and
      localized
     **Implement Smart Play strategy for computer :)




