package main.board;

import main.consts.Symbol;

public class TicTacToeBoard implements Board {

    private final Symbol[][] board;

    private final int size = 3;

    public boolean isDraw() {
        return emptySpaces == 0;
    }

    private int emptySpaces;

    public TicTacToeBoard() {
        board = new Symbol[size][size];
        emptySpaces = size * size;
    }

    public boolean isValidMove(int row, int col){
        return row<size && row>=0 && col>=0 && col<size && board[row][col]==null;
    }

    public void makeMove(int row, int col, Symbol symbol){
        board[row][col] = symbol;
        emptySpaces--;
    }

    public boolean isGameOver(int row, int col){
        if(!isValidMove(row, col)) {
            return false;
        }
        Symbol symbol = board[row][col];
        if(row == col && checkDiagonal(symbol)) {
            return true;
        }
        return rowCheck(row, symbol) || colCheck(col, symbol);
    }

    private boolean checkDiagonal(Symbol symbol) {
        return leftDiagonalCheck(symbol) || rightDiagonalCheck(symbol);
    }

    private boolean rightDiagonalCheck(Symbol symbol) {
        int row = 0, col = size-1;
        while (row<size && col>=0){
            if(board[row++][col--]!=symbol){
                return false;
            }
        }
        return true;
    }

    private boolean leftDiagonalCheck(Symbol symbol) {
        int row = 0, col = 0;
        while(row<size && col<size){
            if(board[row++][col++]!=symbol){
                return false;
            }
        }
        return true;
    }

    private boolean colCheck(int col, Symbol symbol) {
        int row = 0;
        while(row< size){
            if(board[row++][col]!=symbol){
                return false;
            }
        }
        return true;
    }

    private boolean rowCheck(int row, Symbol symbol) {
        int col= 0;
        while(col<size){
            if(board[row][col++]!=symbol){
                return false;
            }
        }
        return true;
    }

    public void displayBoard(){
        for(Symbol[] symbols : board){
            for(Symbol symbol : symbols){
                if(symbol==null){
                    System.out.print(" ");
                }
                else{
                    System.out.print(symbol);
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

}
