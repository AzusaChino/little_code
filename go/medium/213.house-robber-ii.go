package medium

import "math"

func Rob(nums []int) int {
	l := len(nums)
	if l == 0 {
		return 0
	}
	if l == 1 {
		return nums[0]
	}
	return int(math.Max(float64(helper(nums, 0, l-2)), float64(helper(nums, 1, l-1))))
}

func helper(nums []int, l int, h int) int {
	prev, cur := 0, 0

	for i := l; i <= h; i++ {
		temp := int(math.Max(float64(cur), float64(prev+nums[i])))
		prev, cur = cur, temp
	}
	return cur
}
