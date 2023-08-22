package pattern.tictactoe;

import pattern.tictactoe.Controllers.GameController;
import pattern.tictactoe.models.*;
import pattern.tictactoe.strategies.winningstrategies.OrderOneColWinningStrategy;
import pattern.tictactoe.strategies.winningstrategies.OrderOneDiagonalWinningStrategy;
import pattern.tictactoe.strategies.winningstrategies.OrderOneRowWinningStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Create a game
        GameController gameController =new GameController();
        Scanner scanner =new Scanner(System.in);
        Game game;

        int dimension =3;
        List<Player> players=List.of(
                new Player(new Symbol('X'), "Shubham", PlayerType.HUMAN),
                new Bot(new Symbol('O'), "Computer", BotDifficultyLevel.EASY)
        );


        try {
            game = gameController.createGame(
                    3,
                    players,
                    List.of(
                            new OrderOneColWinningStrategy(dimension,players),
                            new OrderOneDiagonalWinningStrategy(players),
                            new OrderOneRowWinningStrategy(dimension,players)
                    )
            );
        } catch (Exception e){
            System.out.println("Something went Wrong : "+ e);
            return;
        }

        System.out.println("-------------- Game Is Starting -------------");

        //While game status in Progress
        while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {
            System.out.println("This is the Board currently looks Like:");
            //print board
            gameController.displayBoard(game);
            //print if undo
            System.out.println("Does Anyone want to Undo? (y/n)");
            // if yes -> call undo
            String input =scanner.next();
            if(input.equalsIgnoreCase("Y")){
                gameController.undo(game);
            }
            else {
                //move next player
                gameController.makeMove(game);
            }


        }


        gameController.printResult(game);





    }
}
