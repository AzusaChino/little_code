package array

func singleNumber2(nums []int) int {
	res := 0
	for i := 0; i < 32; i++ {
		sum := 0
		for _, n := range nums {
			if (n >> i & 1) == 1 {
				sum++
			}
		}
		sum %= 3
		res |= sum << i
	}
	return res
}
