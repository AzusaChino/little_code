package july

func single1(nums []int) int {
	res := 0
	for _, n := range nums {
		res ^= n
	}
	return res
}

func single2(nums []int) int {
	x, y, mask := 0, 0, 0
	for _, n := range nums {
		y ^= x & n
		x ^= n
		mask = ^(x & y)
		y &= mask
		x &= mask
	}
	return x
}
