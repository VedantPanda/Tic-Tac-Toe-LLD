package main;

import main.boardgames.TicTacToeGame;

public class Client {
    public static void main(String[] args) {
        BoardGames ticTacToe = new TicTacToeGame(3);
        ticTacToe.playGame();
        ticTacToe.announceWinner();
    }
}
