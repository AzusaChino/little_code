package array

func singleNumber(nums []int) int {

	n, result := len(nums), 0
	for i := 0; i < n; i++ {
		result ^= nums[i]
	}
	return result
}
