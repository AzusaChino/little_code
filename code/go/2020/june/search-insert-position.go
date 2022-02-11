package june

func insert(nums []int, target int) int {
	l := len(nums)
	for i, n := range nums {
		if target <= n {
			return i
		}
	}
	return l
}
