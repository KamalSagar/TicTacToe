package dev.kamal.tictactoe.services.strategies.winningStrategy;

import dev.kamal.tictactoe.models.Board;
import dev.kamal.tictactoe.models.Move;
import dev.kamal.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy {
    private Map<Integer, Map<Symbol, Integer>> colMap = new HashMap<>();

    @Override
    public boolean isWinning(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        // Check if current column is present in map
        if(!colMap.containsKey(col)){
            colMap.put(col, new HashMap<>());
        }

        Map<Symbol, Integer> colCount = colMap.get(col);

        // Check if current symbol is present in the map
        if(!colCount.containsKey(symbol)){
            colCount.put(symbol,0);
        }

        colCount.put(symbol, colCount.get(symbol) + 1);

        return colCount.get(symbol) == board.getDimension();
    }
}
