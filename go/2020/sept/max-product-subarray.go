package sept

import . "leetcode/common"

func MaxProduct(nums []int) int {
	if nums == nil || len(nums) < 2 {
		return 0
	}
	maxPos, maxNeg, ret := nums[0], nums[0], nums[0]
	for i := 1; i < len(nums); i++ {
		maxPos = Max(maxPos*nums[i], Max(maxNeg*nums[i], nums[i]))
		maxNeg = Min(maxPos*nums[i], Min(maxNeg*nums[i], nums[i]))
		ret = Max(maxPos, ret)
	}
	return ret
}
