package july

func addDigits(n int) int {
	for n >= 10 {
		tmp := 0
		for n > 0 {
			tmp += n % 10
			n /= 10
		}
		n = tmp
	}
	return n
}
