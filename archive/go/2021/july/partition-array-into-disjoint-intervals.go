package july

func partitionDisjoint(nums []int) int {
	localMax, partitionIdx := nums[0], 0
	mx := localMax

	for i := 1; i < len(nums); i++ {
		if localMax > nums[i] {
			localMax = mx
			partitionIdx = i
		} else {
			mx = max(mx, nums[i])
		}
	}
	return partitionIdx + 1
}
