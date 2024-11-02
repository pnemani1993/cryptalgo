class solution:
    def merge(self, nums1: list[int], m: int, nums2: list[int], n: int) -> None:
        index_m = m - 1
        index_n = n - 1
        replace_m = m + n - 1
        
        if m == 0:
            index_m = index_n
        if n == 0:
            return
        
        while index_n >= 0 and index_m >= 0 and replace_m >= 0:
            if nums2[index_n] >= nums1[index_m]:
                nums1[replace_m] = nums2[index_n]
                replace_m -= 1
                index_n -= 1
            else:
                nums1[replace_m] = nums1[index_m]
                replace_m -= 1
                index_m -= 1

        index_m = index_n
        while(index_n >= 0 and index_m >= 0):
            if nums2[index_n] < nums1[index_m] or nums1[index_m] == 0:
                nums1[index_m] = nums2[index_n]
                index_m -= 1
            index_n -= 1