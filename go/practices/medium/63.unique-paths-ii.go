package medium

func UniquePaths2(grid [][]int) int {

	h, w := len(grid), len(grid[0])
	dp := make([]int, w)
	dp[0] = 1

	for i := 0; i < h; i++ {
		for j := 0; j < w; j++ {
			if grid[i][j] == 1 {
				dp[j] = 0
			} else if j > 0 {
				dp[j] += dp[j-1]
			}
		}
	}
	return dp[len(dp)-1]
}
