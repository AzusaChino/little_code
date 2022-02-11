package sept

func arrayNesting(nums []int) int {
	res, n := 0, len(nums)
	seen := make([]bool, n)
	for i := range nums {
		cnt := 0
		for !seen[i] {
			seen[i] = true
			cnt++
			i = nums[i]
		}
		res = max(res, cnt)
	}
	return res
}
