package main

import (
	"cryptalgo/leetcode"
	"fmt"
)

func main() {
	nums1 := []int{1, 2, 3, 4, 5, 6, 0, 0, 0, 0}
	nums2 := []int{3, 5, 8, 10}
	fmt.Println(nums1)
	leetcode.Merge(nums1, 6, nums2, 4)
	fmt.Println(nums1)
}
