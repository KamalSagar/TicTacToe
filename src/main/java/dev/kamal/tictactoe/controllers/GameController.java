package dev.kamal.tictactoe.controllers;

import dev.kamal.tictactoe.models.GameState;
import dev.kamal.tictactoe.models.Player;
import dev.kamal.tictactoe.services.GameService;
import dev.kamal.tictactoe.services.strategies.winningStrategy.WinningStrategy;

import java.util.List;

public class GameController {
    private GameService gameService;

    public GameController(){
        this.gameService = new GameService();
    }

    public void startGame(List<Player> players, List<WinningStrategy> winningStrategies){
        gameService.startGame(players, winningStrategies);

    }

    public void makeMove(){

    }

    public GameState getGameState(){
        return gameService.getGameState();
    }

    public Player getWinner(){
        return gameService.getWinner();
    }

    public void printBoard(){
        gameService.printBoard();
    }


}
