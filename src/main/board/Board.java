package main.board;

import main.consts.Symbol;

public interface Board {
    void makeMove(int row, int col, Symbol symbol);
    boolean isValidMove(int row, int col);
    void displayBoard();
    boolean isGameOver(int row, int col);
    boolean isDraw();
}
