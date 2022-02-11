package sept

func uniquePaths(m int, n int) int {
	dp := make([]int, n)
	for i := range dp {
		dp[i] = 1
	}
	for i := m - 2; i >= 0; i-- {
		for j := n - 2; j >= 0; j-- {
			dp[i] += dp[i+1]
		}
	}
	return dp[0]
}

func uniquePaths2(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	dp := make([]int, n)
	dp[n-1] = 1
	for i := m - 2; i >= 0; i-- {
		for j := n - 2; j >= 0; j-- {
			if grid[i][j] == 0 {
				dp[j] = 0
			} else {
				dp[j] += dp[j+1]
			}
		}
	}
	return dp[0]
}

// define global variable
var ret = 0

var empty = 1

func UniquePaths3(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	var xi, yi int
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 0 {
				empty++
			} else if grid[i][j] == 1 {
				xi, yi = i, j
			}
		}
	}
	_dfs(grid, xi, yi)
	return ret
}

func _dfs(grid [][]int, x int, y int) {
	if x < 0 || x >= len(grid) || y < 0 || y >= len(grid[0]) || grid[x][y] < 0 {
		return
	}
	if grid[x][y] == 2 {
		if empty == 0 {
			ret++
		}
		return
	}
	grid[x][y] = -2
	empty--
	_dfs(grid, x+1, y)
	_dfs(grid, x-1, y)
	_dfs(grid, x, y+1)
	_dfs(grid, x, y-1)
	grid[x][y] = 0
	empty++
}
