package july

func reverse(n int) int {
	if n == 0 {
		return 0
	}

	result := 0
	for i := 0; i < 32; i++ {
		result <<= 1
		if (n & 1) == 1 {
			result++
		}
		n >>= 1
	}
	return result
}
