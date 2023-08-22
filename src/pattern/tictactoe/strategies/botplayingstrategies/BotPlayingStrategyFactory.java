package pattern.tictactoe.strategies.botplayingstrategies;

import pattern.tictactoe.models.BotDifficultyLevel;

import static pattern.tictactoe.models.BotDifficultyLevel.EASY;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        switch (botDifficultyLevel) {
            case EASY:
                return new EasyBotPlayingStrategy();
            case HARD:
                return new HardBotPlayingStrategy();
            case MEDIUM:
                return new MediumBotPlayingStrategy();
            default:
                return new EasyBotPlayingStrategy();


    /*  //Due to java version less than 12 cant use below code
        return switch (botDifficultyLevel){
            case EASY-> new EasyBotPlayingStrategy();
            case HARD-> new HardBotPlayingStrategy();
            case MEDIUM-> new MediumBotPlayingStrategy();
        } */
        }
    }
}
