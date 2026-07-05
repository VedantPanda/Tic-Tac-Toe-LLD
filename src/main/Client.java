package main;

import main.boardgames.TicTacToeGame;

public class Client {
    public static void main(String[] args) {
        BoardGames ticTacToe = new TicTacToeGame();
        ticTacToe.playGame();
        ticTacToe.announceResult();
    }
}
