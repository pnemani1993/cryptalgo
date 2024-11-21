package com.algorithms.algo;

import java.util.Arrays;

public class EightQueens {

    private static final int SIZE = 8;
    private static final String[] PRINT_BOARD = {"X", "X", "X", "X", "X", "X", "X", "X"};
    private static int[] board = {-1, -1, -1, -1, -1, -1, -1, -1};

    public static boolean search(int startPosition) {
        if(startPosition >= SIZE || startPosition < 0){ 
            System.out.println("Invalid startPosition");
            return false;
    }
        int row = 0; 
        while(row >= 0 && row < SIZE){
            int column = findPosition(row, startPosition);
            if(column >= 0){
                board[row] = column;
                row++;
            }
            else{
                board[row] = -1;
                row--;
            }
        }

        if(row == -1){
            return false;
        }

        return true;
    }
    private static int findPosition(int row, int startPosition){
        int start = EightQueens.board[row] + 1;
        if (row == 0) return startPosition;
        for(int j = start; j < EightQueens.SIZE; j++){
            if(isValid(row, j)) return j;
        }
        return -1;
    }
    private static boolean isValid(int row, int column){
        for(int i = 1; i <= row; i++){
            if( EightQueens.board[row - i] == column ||
                EightQueens.board[row - i] == column - i ||
                EightQueens.board[row - i] == column + i
            ) return false;
        }
        return true;
    }

    public static void printBoard(){
        for(int i = 0; i < SIZE; i++){
            String[] newBoard = Arrays.copyOf(PRINT_BOARD, SIZE);
            if(board[i] != -1) newBoard[board[i]] = "O";

            if(i == 0) System.out.print(" ___ ___ ___ ___ ___ ___ ___ ___ ");
            System.out.println();
            System.out.print("| ");
            Arrays.stream(newBoard).forEach(row -> System.out.print(row + " | "));
            if(i == 7){
                System.out.println();
                System.out.print(" --- --- --- --- --- --- --- --- ");
            }
        }
    }

    public static void resetBoard(){
        int[] newBoard = {-1, -1, -1, -1, -1, -1, -1, -1};
        EightQueens.board = Arrays.copyOf(newBoard, SIZE);
    }
}
