package main.boardgames;

import main.BoardGames;
import main.board.Board;
import main.board.TicTacToeBoard;
import main.consts.GameStatus;
import main.consts.Symbol;
import main.players.Player;

import java.util.Scanner;

public class TicTacToeGame implements BoardGames {

    private final Board ticTacToeBoard;

    private final Player XPlayer;

    private final Player OPlayer;

    private Player currentPlayer;

    private Player winner;

    private GameStatus gameStatus;

    private final Scanner sc;

   public TicTacToeGame(Scanner sc) {
       ticTacToeBoard = new TicTacToeBoard();
       this.sc = sc;
       System.out.println("Enter 1st Player Name");
       String p1Name = sc.nextLine();
//       sc.next();
       XPlayer = new Player(Symbol.X, p1Name);
       System.out.println("Enter 2nd Player Name");
       String p2Name = sc.nextLine();
//       sc.next();
       OPlayer = new Player(Symbol.O, p2Name);
       currentPlayer = XPlayer;
   }

    @Override
    public void playGame() {
        while(true){
            ticTacToeBoard.displayBoard();
            System.out.println("Player's turn "+currentPlayer.getName());
            System.out.println("Enter row between 1 and 3");
            int row = sc.nextInt();
            System.out.println("Enter column between 1 and 3");
            int col = sc.nextInt();
            if (!ticTacToeBoard.isValidMove(row-1, col-1)) {
                System.out.println("Invalid move try again");
                continue;
            }
            ticTacToeBoard.makeMove(row-1, col-1, currentPlayer.getSymbol());
            if(ticTacToeBoard.isGameOver(row-1, col-1)) {
                gameStatus = GameStatus.WIN;
                winner = currentPlayer;
                ticTacToeBoard.displayBoard();
                break;
            }
            else if(ticTacToeBoard.isDraw()) {
                gameStatus = GameStatus.DRAW;
                ticTacToeBoard.displayBoard();
                break;
            }
            if(currentPlayer == XPlayer) {
                currentPlayer = OPlayer;
            }
            else {
                currentPlayer = XPlayer;
            }
        }
        sc.close();
    }

    @Override
    public void announceResult() {
       if(GameStatus.WIN.equals(gameStatus)) {
           System.out.println("Winner is "+winner.getName());
       }
       else {
           System.out.println("Match ended in a Draw");
       }
    }

}
