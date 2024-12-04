package com.algorithms.ita4.ch2;

import java.util.Objects;

public class InsertionSort {

    public void sortAscending(int[] array){
        for(int i = 1; i < array.length; i++){
            int key = array[i];
            int j = i - 1;
            while(j > 0 && array[j] > key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }

    public void sortDescending(int[] array){
        for(int i = 1; i < array.length; i++){
            int key = array[i];
            int j = i - 1;
            while(j > 0 && array[j] < key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }    
}
