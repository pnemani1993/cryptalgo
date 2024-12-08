package com.algorithms.algo;

import java.util.stream.IntStream;

public class RecursiveProgramming{

    public int binarySearch(int[] nums, int value){
        if(value < nums[0]) return -1;
        else if(value > nums[nums.length -1]) return -1; 
        else if(value == nums[nums.length/2]) return nums.length/2;
        else if(value < nums[nums.length/2]) return this.binarySearch(nums, value, 0, nums.length/2);
        else return this.binarySearch(nums, value, nums.length/2, nums.length);
    }

    private int binarySearch(int[] nums, int value, int startIndex, int endIndex){
        if(startIndex == endIndex) return -1;
        int mid = (startIndex + endIndex)/2;
        if(value == nums[mid]) return mid;
        else if(value < nums[mid]) return binarySearch(nums, value, startIndex, mid);
        else return binarySearch(nums, value, mid, endIndex);
    }

    public boolean palindromeString(String palin){
        // TODO
        return false;
    }

    public static void main(String[] args) {
        RecursiveProgramming prog = new RecursiveProgramming();
        int[] nums = new int[10001];
        IntStream.range(0, 10001).forEach(index -> {
            nums[index] = index;
        });
            System.out.println(prog.binarySearch(nums, 8647));
        }    
}