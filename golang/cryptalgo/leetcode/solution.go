package leetcode

func Merge(nums1 []int, m int, nums2 []int, n int) {

	var indexM int = m - 1
	indexN := n - 1
	replaceM := m + n - 1

	if m == 0 {
		indexM = indexN
	}

	if n == 0 {
		return
	}

	for indexN >= 0 {
		if nums2[indexN] >= nums1[indexM] {
			nums1[replaceM] = nums2[indexN]
			replaceM--
			indexN--
		} else {
			nums1[replaceM] = nums1[indexM]
			replaceM--
			indexM--
		}
	}
	indexM = indexN
	for indexN >= 0 && indexM >= 0 {
		if nums2[indexN] < nums1[indexM] || nums1[indexM] == 0 {
			nums1[indexM] = nums2[indexN]
			indexM--
		}
		indexN--
	}
}
