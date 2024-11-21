#!/usr/env/bin python
from leetcode.solution import solution

nums1 = [2,0]
nums2 = [1]
merger = solution
def main():
    print(nums1)
    merger.merge(merger,nums1,1,nums2,1)
    print(nums1)

if __name__=="__main__":
    main()