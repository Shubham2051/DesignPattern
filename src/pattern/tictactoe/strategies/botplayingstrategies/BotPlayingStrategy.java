package pattern.tictactoe.strategies.botplayingstrategies;

import pattern.tictactoe.models.Board;
import pattern.tictactoe.models.Cell;

public interface BotPlayingStrategy {

    Cell makeMove(Board board);
}
