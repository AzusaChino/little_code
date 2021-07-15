package july

import "sort"

func triangleNumber(nums []int) int {
	var res = 0
	if len(nums) < 3 {
		return res
	}
	sort.Ints(nums)
	for i := 2; i < len(nums); i++ {
		l, r := 0, i-1
		for l < r {
			if nums[l]+nums[r] > nums[i] {
				res += (r - l)
				r--
			} else {
				l++
			}
		}
	}
	return res
}
