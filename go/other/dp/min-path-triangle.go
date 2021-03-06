package dp

import "leetcode/common"

func minPath(tri [][]int) int {

	// 1. 边界条件
	if tri == nil || len(tri) == 0 || len(tri[0]) == 0 {
		return 0
	}
	// 2. 最后一行 作为dp初始值
	dp := tri[len(tri)-1]
	for i := len(tri) - 2; i >= 0; i-- {
		for j := 0; j < len(tri[i]); j++ {
			// 每次取自己下面两个值中的较小者
			dp[j] = tri[i][j] + common.Min(dp[j], dp[j+1])
		}
	}
	return dp[0]
}
