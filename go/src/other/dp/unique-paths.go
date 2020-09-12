package dp

func UniquePaths(m int, n int) int {

	dp := make([]int, m)
	for i := 0; i < m; i++ {
		dp[i] = 1
	}
	for i := n - 2; i >= 0; i-- {
		for j := m - 2; j >= 0; j-- {
			dp[j] += dp[j+1]
		}
	}
	return dp[0]
}
