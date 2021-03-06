package medium

import "math"

func Longest(text1 string, text2 string) int {
	m, n := len(text1), len(text2)
	dp := make([]int, n)

	for i := 1; i < m; i++ {
		prev := 0
		for j := 1; j < n; j++ {
			temp := dp[j]
			if text1[i-1] == text2[j-1] {
				dp[j] = prev + 1
			} else {
				dp[j] = int(math.Max(float64(dp[j]), float64(dp[j-1])))
			}
			prev = temp
		}
	}
	return dp[n]
}
