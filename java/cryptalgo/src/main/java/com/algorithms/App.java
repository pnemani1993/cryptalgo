package com.algorithms;

import java.util.stream.IntStream;

import com.algorithms.algo.EightQueens;

public class App 
{
    public static void main( String[] args )
    {
        // IntStream.range(0, 8).forEach(e -> System.out.print(e + " "));
        IntStream.range(0, 8).forEach(e -> {
            System.out.println("This is for initial position: " + e);
            EightQueens.search(e);
            EightQueens.printBoard();
            EightQueens.resetBoard();
            System.out.println();
        });
    }
}
