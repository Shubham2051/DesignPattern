package pattern.tictactoe.strategies.botplayingstrategies;

import pattern.tictactoe.models.Board;
import pattern.tictactoe.models.Cell;
import pattern.tictactoe.models.CellState;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Cell makeMove(Board board) {

        for(List<Cell> row : board.getBoard()){
            for (Cell cell: row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return cell;
                }
            }
        }
        return null;
    }
}
