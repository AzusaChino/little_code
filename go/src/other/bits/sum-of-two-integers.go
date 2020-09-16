package bits

func sum(a int, b int) int {
	if b == 0 {
		return a
	} else {
		return sum(a^b, (a&b)<<1)
	}
}
