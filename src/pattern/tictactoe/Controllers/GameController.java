package pattern.tictactoe.Controllers;

import pattern.tictactoe.models.Game;
import pattern.tictactoe.models.GameStatus;
import pattern.tictactoe.models.Player;
import pattern.tictactoe.strategies.winningstrategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game createGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){

            return Game.getBuilder()
                    .setDimension(dimension)
                    .setPlayers(players)
                    .setWinningStrategies(winningStrategies)
                    .Build();

    }

    public void displayBoard(Game game){
        game.printBoard();
    }

    public void undo(Game game){
        game.undo();

    }

    public void makeMove(Game game){
        game.makeMove();

    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }


    public void printResult(Game game){
        game.printResult();
    }
}
