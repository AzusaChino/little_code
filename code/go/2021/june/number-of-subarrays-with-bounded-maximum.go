package june

func numSubarrayBoundedMax(nums []int, left int, right int) int {
	res, dp := 0, 0
	prev := -1

	for i, v := range nums {
		if v > right {
			dp = 0
			prev = i
		}
		if left <= v && v <= right {
			dp = i - prev
		}
		res += dp
	}
	return res
}
