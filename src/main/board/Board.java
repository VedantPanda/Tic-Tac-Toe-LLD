package main.board;

import main.consts.Symbol;

public class Board {

    private final int size;
    private final Symbol[][] board;

    public int getEmptySpaces() {
        return emptySpaces;
    }

    private int emptySpaces;

    public Board(int size) {
        this.size = size;
        this.board = new Symbol[size][size];
        emptySpaces = size*size;
    }

    public boolean isValidMove(int row, int col){
        return row<size && row>=0 && col>=0 && col<size && board[row][col]==null;
    }

    public void makeMove(int row, int col, Symbol symbol){
        board[row][col] = symbol;
        emptySpaces--;
    }

    public boolean isGameOver(int row, int col){
        Symbol symbol = board[row][col];
        return rowCheck(row, symbol) || colCheck(col, symbol) || checkDiagonal(symbol);
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
