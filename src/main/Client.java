package main;

import main.boardgames.TicTacToeGame;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        BoardGames ticTacToe = new TicTacToeGame(new Scanner(System.in));
        ticTacToe.playGame();
        ticTacToe.announceResult();
    }
}
