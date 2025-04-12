package main.strategy.player.impl;

import main.Position;
import main.board.Board;
import main.strategy.player.PlayerStrategy;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {

    private final Scanner scanner;

    public HumanPlayerStrategy() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Position makeMove(Board board) {
        while (true){
            System.out.println("Enter row");
            int row = scanner.nextInt();
            System.out.println("Enter column");
            int col = scanner.nextInt();
            if(!board.isValidMove(row, col)){
                System.out.println("Move is invalid...try again");
            }
            else{
                return new Position(row, col);
            }
        }
    }
}
