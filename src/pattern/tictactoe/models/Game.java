package pattern.tictactoe.models;

import pattern.builder.Builder;
import pattern.tictactoe.strategies.winningstrategies.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private List<Move> moves;
    private Board board;
    private List<Player> players;
    private int currentMovePlayerIndex;
    private List<WinningStrategy> winningStrategies;
    private GameStatus gameStatus;
    private Player winner;

    public static Builder getBuilder(){
        return new Builder();
    }

    private  Game(int dimension,List<Player> players, List<WinningStrategy> winningStrategies){
        this.moves=new ArrayList<>();
        this.board=new Board(dimension);
        this.players=players;
        this.currentMovePlayerIndex=0;
        this.winningStrategies =winningStrategies;
        this.gameStatus=GameStatus.IN_PROGRESS;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getCurrentMovePlayerIndex() {
        return currentMovePlayerIndex;
    }

    public void setCurrentMovePlayerIndex(int currentMovePlayerIndex) {
        this.currentMovePlayerIndex = currentMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void printBoard(){
        this.board.print();
    }

    public void printWinner(){
        System.out.println(winner);
    }

    public void printResult(){
        if(gameStatus.equals(GameStatus.ENDED)){
            System.out.println("Game had Ended.");
            System.out.println("Winner is :" +winner.getName());
        }
        else{
            System.out.println("Game is Draw");
        }
    }

    private boolean validateMove(Cell cell){
        int row=cell.getRow();
        int col=cell.getCol();

        if( row<0 || col<0 || row>=board.getSize() || col>=board.getSize()){
            return false;
        }

        if (board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)){
            return true;
        }
        else {
            return false;
        }

    }

    public void makeMove(){
        Player currentPlayer =players.get(currentMovePlayerIndex);
        System.out.println("It is " + currentPlayer.getName() + "'s turn.");

        Cell proposedCell=currentPlayer.makeMove(board);
        System.out.println("Move made at row: " + proposedCell.getRow() + " col: " + proposedCell.getCol() + ".");

        if(!validateMove(proposedCell)){
            System.out.println("invalid move. Retry.");
            return;
        }

        Cell cellInBoard =board.getBoard().get(proposedCell.getRow()).get(proposedCell.getCol());
        cellInBoard.setCellState(CellState.FILLED);
        cellInBoard.setPlayer(currentPlayer);

        Move move= new Move(currentPlayer,cellInBoard);
        moves.add(move);

        if (checkGameWon(currentPlayer, move)) return;

        if (checkDraw()) return;

        currentMovePlayerIndex+=1;
        currentMovePlayerIndex%=players.size();


    }

    public void undo(){
        if(moves.size() ==0){
            System.out.println("No Moves Can't Undo.");
        }

        Move lastMove= moves.get(moves.size()-1);

        for(WinningStrategy winningStrategy: winningStrategies){
            winningStrategy.handleUndo(board,lastMove);
        }

        Cell cellInBoard =lastMove.getCell();
        cellInBoard.setCellState(CellState.EMPTY);
        cellInBoard.setPlayer(null);

        moves.remove(lastMove);

        currentMovePlayerIndex-=1;
        currentMovePlayerIndex+=players.size();
        currentMovePlayerIndex%=players.size();

    }

    private boolean checkDraw() {
        if(moves.size() == board.getSize() * board.getSize()){
            gameStatus=GameStatus.DRAW;
            return true;
        }
        return false;
    }

    private boolean checkGameWon(Player currentPlayer, Move move) {
        for(WinningStrategy winningStrategy: winningStrategies){
            if(winningStrategy.checkWinner(board, move)){
                gameStatus=GameStatus.ENDED;
                winner= currentPlayer;
                return true;
            }
        }
        return false;
    }

    // Creating Builder class for Validation
    public static class Builder{

        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;
        private Builder(){}

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        private boolean valid(){
            if(this.players.size()<2){
                return false;
            }
            if(this.players.size()!=this.dimension-1){
                return false;
            }
            int botCount=0;
            for (Player player:this.players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }
            if(botCount>=2){
                return false;
            }
            Set<Character> existingSymbols =new HashSet<>();

            for(Player player :players){
                if(existingSymbols.contains(player.getSymbol().getaChar())){
                    return false;
                }
                existingSymbols.add(player.getSymbol().getaChar());
            }
            return true;
        }

        public Game Build(){
            if(!valid()) {
                throw new RuntimeException("Invalid params for Game");
            }
            return new Game(dimension,players,winningStrategies);
        }
    }
}
