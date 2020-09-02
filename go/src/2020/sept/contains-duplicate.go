package sept

func containsDuplicate1(nums []int) bool {
	dict := make(map[int]bool)
	for _, i := range nums {
		if dict[i] {
			return true
		}
		dict[i] = true
	}
	return false
}
