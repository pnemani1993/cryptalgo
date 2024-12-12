package com.algorithms.algo;

import java.util.Arrays;

public class QueensProblem{

    private int startPosition;
    private static final int SIZE = 8;
    private static final int[] INITIAL_BOARD_SETUP = new int[]{-1,-1,-1,-1,-1,-1,-1,-1};
    private static final String[] PRINTABLE_ROW = new String[]{"X", "X", "X", "X", "X", "X", "X", "X"};
    private static String[][] PRINTABLE_BOARD = new String[SIZE][SIZE];
    private int[] board;

    public static void main(String[] args) {
        QueensProblem qProblem = new QueensProblem();
        System.out.println();
        // qProblem.getBoard();
        qProblem.printBoard();
        // qProblem.getBoard();
        System.out.println();
        qProblem.setStartPosition(4);
        qProblem.printBoard();
        // qProblem.getBoard();
    }

    QueensProblem(){
        this.startPosition = 0;
        this.board = new int[]{-1,-1,-1,-1,-1,-1,-1,-1};
        search();
    }

    QueensProblem(int startPosition){
        if(startPosition < 0 || startPosition >= SIZE) throw new RuntimeException("Illegal value for start position: Value should be between 0-7");
        this.startPosition = startPosition;
        this.board = new int[]{-1,-1,-1,-1,-1,-1,-1,-1};
        search();
    }

    public int getStartPosition(){
        return this.startPosition;
    }

    public void setStartPosition(int startPosition){
        if(startPosition < 0 || startPosition >= SIZE) throw new RuntimeException("Illegal value for start position: Value should be between 0-7");
        this.startPosition = startPosition;
        search();
    }

    public boolean search(){
        int row = 0;
        while(row >= 0 && row < SIZE){
            int column = findPosition(row);
            if(column < 0){
                this.board[row] = -1;
                row--;
            }
            else{
                this.board[row] = column;
                row++;
            }
        }
        if(row == -1) return false;
        setBoard();
        return true;
    }

    private int findPosition(int row){
        if(row == 0) return this.startPosition;
        int start = this.board[row] + 1;
        for(int j = start;j < SIZE; j++){
            if(isValid(row, j)) return j;
        }
        return -1;
    }

    private boolean isValid(int row, int column){
        for(int i = 1; i <= row; i++){
            if(board[row - i] == column ||
            board[row - i] == column - i ||
            board[row - i] == column + i) return false; 
        }
        return true;
    }

    public void getBoard(){
        for(int i = 0; i < SIZE; i++){
            System.out.print(board[i] + " ");
        }
    }

    private void setBoard(){
        for(int i = 0; i < SIZE; i++){
            PRINTABLE_BOARD[i] = Arrays.copyOf(PRINTABLE_ROW, 8);
        }
        for(int i = 0; i < SIZE; i++){
            PRINTABLE_BOARD[i][this.board[i]] = "8";
        }
    }

    public void printBoard(){
        for(int i = 0; i < SIZE; i++){
            System.out.print("| ");
            for(int j = 0; j < SIZE; j++){
                System.out.print(PRINTABLE_BOARD[i][j] + " | ");
            }
            System.out.println();
        }
    }


}
