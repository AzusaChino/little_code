package july

func ArrangeCoins(n int) int {
	if n == 1 {
		return 1
	}
	var i = 1
	for i <= n {
		n -= i
		i++
	}
	return i - 1
}
