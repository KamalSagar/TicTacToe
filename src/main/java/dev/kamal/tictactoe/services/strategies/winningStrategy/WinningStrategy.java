package dev.kamal.tictactoe.services.strategies.winningStrategy;

import dev.kamal.tictactoe.models.Board;
import dev.kamal.tictactoe.models.Move;

public interface WinningStrategy {
    boolean isWinning(Board board, Move move);
}
