package pattern.tictactoe.strategies.winningstrategies;

import pattern.tictactoe.models.Board;
import pattern.tictactoe.models.Move;

public interface WinningStrategy {

    boolean checkWinner(Board board, Move move);

    void handleUndo(Board board,Move move);

}
