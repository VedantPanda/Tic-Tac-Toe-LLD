package main.boardgames;

import main.BoardGames;
import main.Position;
import main.board.Board;
import main.consts.Symbol;
import main.factory.playerstrategy.PlayerStrategyFactory;
import main.players.Player;

import java.util.Deque;
import java.util.LinkedList;

public class TicTacToeGame implements BoardGames {

    private final Board board;

    private String winnerName;

    private final Deque<Player> players;

    public TicTacToeGame(int boardSize) {
        this.board = new Board(boardSize);
        players = new LinkedList<>();
        Player XPlayer = new Player(Symbol.X, PlayerStrategyFactory.getPlayerStrategy("Human"), "Alex");
        Player OPlayer = new Player(Symbol.O, PlayerStrategyFactory.getPlayerStrategy("Human"), "Michael");
        players.add(XPlayer);
        players.add(OPlayer);
    }

    @Override
    public void playGame() {
        while(true){
            board.displayBoard();
            Player currentPlayer = players.removeFirst();
            Position position = currentPlayer.getPlayerStrategy().makeMove(board);
            board.makeMove(position.getRow(), position.getCol(), currentPlayer.getSymbol());
            if(board.isGameOver(position.getRow(), position.getCol())){
                board.displayBoard();
                winnerName = currentPlayer.getName();
                break;
            }
            if(board.getEmptySpaces()==0){
                board.displayBoard();
                break;
            }
            players.addLast(currentPlayer);
        }
    }

    @Override
    public void announceWinner(){
        if(winnerName!=null){
            System.out.println("Winner is "+winnerName);
        }
        else{
            System.out.println("Game is tied");
        }
    }

}
