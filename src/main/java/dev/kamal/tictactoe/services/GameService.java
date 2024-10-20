package dev.kamal.tictactoe.services;

import dev.kamal.tictactoe.models.*;
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

    private boolean checkWinner(Move move){
        for(WinningStrategy strategy: game.getWinningStategies()){
            if(strategy.isWinning(game.getBoard(), move)) {
                return true;
            }
        }
        return false;
    }

    public void makeMove(){
        Player currentPlayer = game.getPlayers().get(game.getNextPlayerIndex());
        Cell moveCell = currentPlayer.makeMove(game.getBoard());

        // Valid Move, we can execute on the board
        Cell currentCell = game.getBoard().getBoard().get(moveCell.getRow()).get(moveCell.getCol());
        currentCell.setCellState(CellState.FILLED);
        currentCell.setPlayer(currentPlayer);
        Move finalMove = new Move(currentPlayer, currentCell);
        game.getMoves().add(finalMove);

        // set the next player index
        int nextPlayerIndex = game.getNextPlayerIndex();
        nextPlayerIndex = (nextPlayerIndex + 1) % game.getPlayers().size();
        game.setNextPlayerIndex(nextPlayerIndex);

        // Check winner or draw
        if(checkWinner(finalMove)){
            game.setWinner(currentPlayer);
            game.setGameState(GameState.ENDED);
        }
        else if(game.getMoves().size() == (game.getBoard().getDimension() * game.getBoard().getDimension())){
            game.setGameState(GameState.DRAW);
        }




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
