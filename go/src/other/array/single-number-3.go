package array

func singleNumber3(nums []int) (res []int) {
	diff := 0
	for n := range nums {
		diff ^= n
	}

	diff &= -diff

	var result = make([]int, 2)
	result[0], result[1] = 0, 0

	for n := range nums {
		if (n & diff) == 0 {
			result[0] ^= n
		} else {
			result[1] ^= n
		}
	}
	return result
}
