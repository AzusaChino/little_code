package july

import "math"

func isUglyNumber(num int) bool {
	for i := 2; i < 6 && num > 0; i++ {
		for num%i == 0 {
			num /= i
		}
	}
	return num == 1
}

func nthUglyNumber(n int) int {
	if n <= 1 {
		return n
	}
	p2, p3, p5 := 0, 0, 0
	dp := make([]int, n)
	dp[0] = 1
	for i := 1; i < n; i++ {
		dp[i] = int(math.Min(float64(dp[p2]*2), math.Min(float64(dp[p3]*3), float64(dp[p5]*5))))
		if dp[i] == dp[p2]*2 {
			p2++
		}
		if dp[i] == dp[p3]*3 {
			p3++
		}
		if dp[i] == dp[p5]*5 {
			p5++
		}
	}
	return dp[n-1]
}
