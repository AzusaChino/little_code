package easy

import "math"

var memo []int

/**
 * rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )
 */
func rob(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}
	return helper(nums, len(nums)-1)
}

func helper(nums []int, i int) int {
	if i < 0 {
		return 0
	}
	return int(math.Max(float64(helper(nums, i-2)+nums[i]), float64(helper(nums, i-1))))
}

func rob2(nums []int) int {
	if nums == nil || len(nums) == 0 {
		return 0
	}
	if len(nums) == 1 {
		return nums[0]
	}
	memo = make([]int, len(nums))
	return helper2(nums, len(nums)-1)
}

func helper2(nums []int, i int) int {
	if i == 0 {
		return 0
	}
	if memo[i] > 0 {
		return memo[i]
	}
	result := int(math.Max(float64(helper(nums, i-2)+nums[i]), float64(helper(nums, i-1))))
	memo[i] = result
	return result
}

func rob3(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	n := len(nums)
	dp := make([]int, n)
	dp[0] = 0
	dp[1] = nums[0]
	for i := 1; i < n; i++ {
		dp[i+1] = int(math.Max(float64(dp[i]), float64(dp[i-1]+nums[i])))
	}
	return dp[n]
}

func finalRob(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	prev1, prev2 := 0, 0
	for _, n := range nums {
		tmp := prev1
		prev1 = int(math.Max(float64(prev1), float64(prev2+n)))
		prev2 = tmp
	}
	return prev1
}
