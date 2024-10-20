package dev.kamal.tictactoe;

import dev.kamal.tictactoe.controllers.GameController;
import dev.kamal.tictactoe.models.GameState;
import dev.kamal.tictactoe.models.Player;
import dev.kamal.tictactoe.models.PlayerType;
import dev.kamal.tictactoe.models.Symbol;
import dev.kamal.tictactoe.services.strategies.winningStrategy.ColumnWinningStrategy;
import dev.kamal.tictactoe.services.strategies.winningStrategy.RowWinningStrategy;
import dev.kamal.tictactoe.services.strategies.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        playTicTacToe();
    }

    private static void playTicTacToe() {
        System.out.println("Let's play Tic Tac Toe");

        List<Player> players = new ArrayList<>();

        players.add(new Player("Kamal", new Symbol('K'), PlayerType.HUMAN));
        players.add(new Player("Rahul", new Symbol('R'), PlayerType.HUMAN));

        List<WinningStrategy> winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColumnWinningStrategy()
        );

        GameController gameController = new GameController();
        gameController.startGame(players, winningStrategies);

        // Play the game
        while( gameController.getGameState() == GameState.IN_PROGRESS){
            gameController.printBoard();
            gameController.makeMove();
        }

        // Game over
        System.out.println("Game Over!");
        gameController.printBoard();
        if(gameController.getGameState() == GameState.ENDED){
            System.out.println("Winner is: " + gameController.getWinner().getName());
        }
        else{
            System.out.println("It's a draw!");
        }
    }


}
