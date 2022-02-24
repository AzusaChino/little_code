package march

func wiggleMaxLength(nums []int) int {
	if len(nums) < 2 {
		return len(nums)
	}
	var up = make([]int, len(nums))
	var down = make([]int, len(nums))

	up[0] = 1
	down[0] = 1
	for i := range nums {
		if nums[i] > nums[i-1] {
			up[i] = down[i-1] + 1
			down[i] = down[i-1]
		} else if nums[i] < nums[i-1] {
			down[i] = up[i-1] + 1
			up[i] = up[i-1]
		} else {
			down[i] = down[i-1]
			up[i] = up[i-1]
		}
	}
	return max(down[len(nums)-1], up[len(nums)-1])
}
