package com.algorithms.leetcode;

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

}