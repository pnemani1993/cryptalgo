package com.algorithms.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.regex.MatchResult;
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

    public static void testBinarySearch(){
        RecursiveProgramming prog = new RecursiveProgramming();
        int[] nums = new int[10001];
        IntStream.range(0, 10001).forEach(index -> {
            nums[index] = index;
        });
            System.out.println(prog.binarySearch(nums, 8647));
    } 

    public boolean palindromeString(String palin){
        if(palin.length() <= 1) return true;
        if(palin.charAt(0) == palin.charAt(palin.length() - 1)) return palindromeString(palin.substring(1, palin.length() - 1));
        else return false;
    }
    
    public static void testPalindromeString(){
        RecursiveProgramming prog = new RecursiveProgramming();
        String testString1 = "abcdcba";
        String testString2 = "abcddcba";
        String testString3 = "abcdeddcba";
        System.out.println("Is " + testString1 + " palindrome: " + prog.palindromeString(testString1));
        System.out.println("Is " + testString2 + " palindrome: " + prog.palindromeString(testString2));
        System.out.println("Is " + testString3 + " palindrome: " + prog.palindromeString(testString3));
        
    }

    public int[] binarySelectionSort(int[] nums){
        if(nums.length - 1 == 0) return nums;
        OptionalInt optionalInt = Arrays.stream(nums).min();
        int minIndex = 0;
        for(; minIndex < nums.length; minIndex++){
            if(optionalInt.getAsInt() == nums[minIndex]) break;
        }
        int temp = optionalInt.getAsInt();
        nums[minIndex] = nums[0];
        nums[0] = temp;
        return binarySelectionSort(nums, 1);
    }

    private int[] binarySelectionSort(int[] nums, int index){
        if(nums.length - 1 == index) return nums;
        OptionalInt optionalInt = Arrays.stream(nums).skip(index).min();
        int minIndex = index;
        for(; minIndex < nums.length; minIndex++){
            if(optionalInt.getAsInt() == nums[minIndex]) break;
        }
        int temp = optionalInt.getAsInt();
        nums[minIndex] = nums[index];
        nums[index] = temp;
        index++;
        return binarySelectionSort(nums, index);
    }

    public static void testBinarySelectionSort(){
        RecursiveProgramming prog = new RecursiveProgramming();
        int[] nums = new int[1001];
        for(int i = 0; i < nums.length; i++){
            nums[i] = 1000 - i;
        }
        nums = prog.binarySelectionSort(nums);
        for(int i: nums){
            System.out.print(i + " ");
        }
    }

    public static List<String> permuteString(String str){
        List<String> permutedString = new ArrayList<>();
        String selected = "";
        permute(str, selected, permutedString);
        return permutedString;
        
    }

    private static void permute(String str, String selected, List<String> list){
        if(str.length() == 0){
            list.add(selected);
            return;
        } 
            
        for(int i = 0; i < str.length(); i++){
                selected += str.charAt(i);
                str = str.substring(0,i) + str.substring(i + 1);
                permute(str,selected, list);
        }
    }

    public static List<String> recursivePermuteString(String str){
            Set<String> setEx = new HashSet<>();
            recursivePermuteString(str, "", setEx);
            return new ArrayList<String>(setEx);
    } 

    public static void recursivePermuteString(String str, String ans, Set<String> set){
        if(str.length() == 0){
            set.add(ans);
            return;
        }
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            recursivePermuteString(remaining, ans + ch, set);
        }
    }

    public static void testStringPermutation(){
        String newStr = "tesla";
        List<String> permutedList = permuteString(newStr);
        System.out.println(permutedList);
    }

    static void printPermutn(String str, String ans)
    {
 
        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
 
        for (int i = 0; i < str.length(); i++) {
 
            // ith character of str
            char ch = str.charAt(i);
 
            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                        str.substring(i + 1);
 
            // Recursive call
            printPermutn(ros, ans + ch);
        }
    }

    public static long pickGifts(int[] gifts, int k) {
        long sum = 0;
        int times = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e2.compareTo(e1));
        for(int i = 0; i < gifts.length; i++){
            pq.add(gifts[i]);
        }
        while(times < k){
            pq.add((int) Math.floor(Math.sqrt(pq.poll())));
            times++;
        }
        for(int i = 0; i < gifts.length; i++){
            sum += pq.poll();
        }
        return sum;
    }

    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1, e2) -> e2.compareTo(e1));
        int sum = 0;
        int times = 0;
        for(int i = 0; i < piles.length; i++){
            pq.add(piles[i]);
        }

        while(times < k){
            int max = pq.poll();
            if(max%2 == 1) max = (max/2) + 1;
            else max = max/2;
            pq.add(max);
            times++;
        }

        for(int i = 0; i < piles.length; i++){
            sum += pq.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
            // testPalindromeString();
            // testBinarySelectionSort();
            // testStringPermutation();
            int[] arr = new int[]{5,4,9};
            int[] newPile = new int[]{4,3,6,7};
            System.out.println(minStoneSum(arr, 2));
            System.out.println(minStoneSum(newPile, 3));
        }    
}