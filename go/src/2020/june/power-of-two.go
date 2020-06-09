package june

func isPowerOfTwo(n int) bool {
	for n > 1 {
		if n&1 == 1 {
			return false
		}
		n /= 2
	}
	return true
}
