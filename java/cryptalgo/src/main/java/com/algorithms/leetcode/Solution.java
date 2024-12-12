package com.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 88. Merge Sorted Array
         * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
         * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
         * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, 
         * where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
         * Example 1:
         *   Input: nums1 = [4,5,6,0,0,0], m = 3, nums2 = [1,2,3], n = 3
         *   Output: [1,2,2,3,5,6]
         *   Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
         *   The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
         */
        int indexM = m - 1; 
        int indexN = n - 1;
        int placeM = m + n - 1;
        
        if(m == 0){
            indexM = indexN;
        } 
        if(n == 0) return;
        
        while(indexN >= 0 && indexM >= 0 && placeM >= 0){
            if(nums2[indexN] >= nums1[indexM]){
                nums1[placeM] = nums2[indexN];
                placeM--;
                indexN--;
            }
            else {
                nums1[placeM] = nums1[indexM];
                placeM--;
                indexM--;
            }
        }
        indexM = indexN;
        while(indexN >= 0 && indexM >= 0){
            if(nums2[indexN] < nums1[indexM] || nums1[indexM] == 0){
                nums1[indexM] = nums2[indexN];
                indexM--;
            }
            indexN--;
        }
    }

    public static int trap (int[] height){
        /**
         * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
         * Example 1:
         * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
         * Output: 6
         * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
         */
        
        int trappedWater = 0;
        
        int slow = 0;
        int fast = 1;

        while(slow < height.length && fast < height.length){
            while(fast < height.length && slow < height.length && height[slow] > 0 && height[fast] < height[slow]){
                fast++;
            }
            int index = slow;
            while(index < fast && height[slow] > 0 && fast < height.length){
                trappedWater += height[slow] - height[index];
                index++;
            }
            
            if(slow != height.length -1 && fast != height.length){
                slow = fast;
                fast = slow + 1;
            }
            else{
                slow++;
                fast = slow + 1;
            }
        }

        return trappedWater;
    }

    public static int removeElement(int[] nums, int val) {
        /**
         * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
         * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
         * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
         * Return k.
         * Custom Judge:
         * The judge will test your solution with the following code:
         * int[] nums = [...]; // Input array
         * int val = ...; // Value to remove
         * int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.
         * int k = removeElement(nums, val); // Calls your implementation
         * assert k == expectedNums.length;
         * sort(nums, 0, k); // Sort the first k elements of nums
         * for (int i = 0; i < actualLength; i++) {
         *     assert nums[i] == expectedNums[i];
         * }
         * If all assertions pass, then your solution will be accepted.
         * Example 1:
         * Input: nums = [3,2,2,3], val = 3
         * Output: 2, nums = [2,2,_,_]
         * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
         * It does not matter what you leave beyond the returned k (hence they are underscores).
         */
        int returnValue = nums.length;
        int index = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                nums[i] = nums[index];
                nums[index] = -11;
                index--;
                i--;
                returnValue--;
            }
        }

        return returnValue;
    }

    /** 
     * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
    *
    *        Return true if you can reach the last index, or false otherwise.
    *
    *        
    *   
    *        Example 1:
    *
    *        Input: nums = [2,3,1,1,4]
    *        Output: true
    *        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
    *
    *        Example 2:
    *
    *        Input: nums = [3,2,1,0,4]
    *        Output: false
    *        Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
    *
    *        
    *
    *        Constraints:
    *
    *            1 <= nums.length <= 104
    *            0 <= nums[i] <= 105
    *
    *
     */
    public static boolean canJump(int[] nums){
        if(nums.length == 1) return true;
        if(nums.length == 2 && nums[0] > 0) return true;
        if(nums[0] == 0) return false;
        int mainIndex = nums.length - 1;
        int jumpIndex = nums.length - 2;
        while(mainIndex > 0 && jumpIndex >= 0){
            if(nums[jumpIndex] >= mainIndex - jumpIndex){
                mainIndex = jumpIndex;
                jumpIndex--;
            }
            else{
                jumpIndex--;
            }
        }
        if (mainIndex == 0) return true;
        return false;
    }

    public static int jump(int[] nums){
        if(nums.length == 1 ) return 0;
        if( nums.length == 2 ) return 1;
        int steps = 0;
        int mainIndex = nums.length - 1;
        int jumpIndex = nums.length - 2;
        while(mainIndex > 0){
            mainIndex = countJumps(nums, mainIndex, jumpIndex);
            jumpIndex = mainIndex - 1;
            steps++;
        }
        return steps;
    }

    public static int countJumps(int[] nums, int mainIndex, int jumpIndex){
        int staticIndex = jumpIndex;
        while(jumpIndex >= 0){
            if(nums[jumpIndex] >= mainIndex - jumpIndex && isReachable(nums, jumpIndex)){
                staticIndex = jumpIndex;
            } 
            jumpIndex--;
        }
        return staticIndex;
    }

    public static boolean isReachable(int[] nums, int index){
        int jumpIndex = index - 1;
        while( jumpIndex >=0 ){
            if(nums[jumpIndex] >= index - jumpIndex) return true;
            else{
                jumpIndex--;
            }
        }
        if(jumpIndex == -1) return true;
        return false;
    }

    // 20241209 Climbing Stairs: Dynamic Programming (Easy) #70
    public static int climbingStairs(int n){
        if(n == 1) return 1;
        else if(n == 2) return 2;
        else if(n ==3) return 3;
        return climbingStairs(n -1) + climbingStairs(n-2);
    } 

    public static int climbStairs(int n){
        if(n == 1 || n == 0) return 1;

        Map<Integer, Integer> mapping = new HashMap<>();

        return climbStairs(n,mapping);

    }

    static int climbStairs(int num, Map<Integer, Integer> mapping){
        if(num == 1 || num == 0) return 1;
        if(!mapping.containsKey(num)){
            mapping.put(num, climbStairs(num - 1, mapping) + climbStairs(num - 2, mapping));
        }

        return mapping.get(num);
    } 

    static void testClimbStairs(){
        System.out.println("For 2: " + climbStairs(2) );
        System.out.println("For 7: " + climbStairs(7));
        System.out.println("For 41: " + climbStairs(41));
        System.out.println("For 45: " + climbStairs(45));
    }



    public static int maximumLength(String s) {
        
        int[] alpha = new int[26];
        final int DIFF = 97;

        for(int i = 0; i < s.length(); i ++) {
            alpha[s.charAt(i) - 97]++;
        }
        
        if(!Arrays.stream(alpha).anyMatch(value -> value >= 3)) return -1;

        

        return 1;

    }

    // # 2981 Leetcode: Find longest special substring
    static boolean containsSpecial(String str){
        Map<String, Integer> mapping = new HashMap<>();
        
        for(int i = 0; i < str.length(); i ++) {
            String ch = String.valueOf(str.charAt(i));
            if(mapping.containsKey(ch)) mapping.put(ch, mapping.get(ch) + 1);
            else mapping.put(ch, 1);
        }
        
        return mapping.values().stream().anyMatch(value -> value >= 3);
    }

    public static int divide(int dividend, int divisor) {
        if(dividend == 0 || divisor == -2147483648) return 0;
        if(dividend == -2147483648 && divisor == -1) return 2147483647;
        if(divisor == 1) return dividend;
        boolean isNegative;
        if((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0) ) isNegative = false;
        else isNegative = true;
        if (!isNegative && dividend > 0 && divisor > dividend) return 0;
        if(isNegative && divisor == -1) return -dividend; 
        if(!isNegative && dividend < 0 && divisor < dividend) return 0;
        
        int quotient = 0;
        int number = dividend;
        if(isNegative && dividend < 0){
            while(number < -divisor){
                number += divisor;
                quotient++;
            }
            return -quotient;
        } 
        else if(isNegative && divisor < 0){
            while(number >= -divisor){
                number += divisor;
                quotient++;
            }
            return -quotient;
        } 
        else if(!isNegative && dividend < 0){
            while(number <= divisor){
                number -= divisor;
                quotient++;
            }
            return quotient;
        }        
        while(number >= divisor){
            number -= divisor;
            quotient++;
        }
        return quotient;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> returnArray = new ArrayList<>();

        return returnArray;
    }

    public static int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        int prev = 0, curr = 1;
        for( int i = 2; i <= n; i++){
            int temp = curr;
            curr = curr + prev;
            prev = temp;
        }
        return curr;
    }

    public static void testFib(){
        System.out.println("2: " + fib(2) );
        System.out.println("5: " + fib(5));
        System.out.println("30: " + fib(30));
    }

    public static int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(sum < 0) sum = 0;
            sum += nums[i];
            if(sum > max) max = sum;
        }
        return max;
    }

    public static void testMaxSubArray(){
        int[] arr1 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] arr2 = new int[]{5,4,-1,7,8};
        System.out.println("For array 1: " + maxSubArray(arr1));
        System.out.println("For array 2: " + maxSubArray(arr2));
    }

    public static int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int maxProfit = 0;
        int sum = 0;
        int[] diff = new int[prices.length - 1];
        for(int i = 0; i < prices.length - 1; i++){
            diff[i] = prices[i + 1] - prices[i];
        } 
        for(int i = 0; i < diff.length; i++){
            if(sum < 0) sum = 0;
            sum += diff[i];
            if(sum > maxProfit) maxProfit = sum;
        }

        return maxProfit; 
    }

    public static void testMaxProfit(){
        int[] arr1 = new int[]{7,1,5,3,6,4};
        int[] arr2 = new int[]{7,6,4,3,1};

        System.out.println("Profit for prices 1: " + maxProfit(arr1));
        System.out.println("Profit for prices 2: " + maxProfit(arr2));
    }



    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // testClimbStairs();
        // testFib();
        // testMaxSubArray();
        testMaxProfit();
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - startTime) + "ms");
        // System.out.println(maximumLength("abacadae"));
    }

}