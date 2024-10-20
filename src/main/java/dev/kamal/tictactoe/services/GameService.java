package dev.kamal.tictactoe.services;

import dev.kamal.tictactoe.models.Cell;
import dev.kamal.tictactoe.models.Game;
import dev.kamal.tictactoe.models.GameState;
import dev.kamal.tictactoe.models.Player;
import dev.kamal.tictactoe.services.strategies.winningStrategy.WinningStrategy;

import java.util.List;

public class GameService {
    private Game game;


    public void startGame(List<Player> players, List<WinningStrategy> winningStrategies){
        game = Game.getBuilder()
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(){
        Player currentPlayer = game.getPlayers().get(game.getNextPlayerIndex());
        Cell moveCell = currentPlayer.makeMove(game.getBoard());

        // Valid Move, we can execute on the board
    }

    public GameState getGameState(){
        return game.getGameState();
    }

    public Player getWinner(){
        return game.getWinner();
    }

    public void printBoard(){
        game.getBoard().printBoard();
    }
}
