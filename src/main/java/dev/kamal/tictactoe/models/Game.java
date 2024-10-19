package dev.kamal.tictactoe.models;


import dev.kamal.tictactoe.services.strategies.winningStrategy.WinningStrategy;

import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private Player winner;
    private List<Move> moves;
    private GameState gameState;
    private int nextPlayerIndex;
    List<WinningStrategy> winningStategies;
}
