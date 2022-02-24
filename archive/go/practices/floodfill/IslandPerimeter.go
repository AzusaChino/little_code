package floodfill

var dir = [][]int{
	{0, 1},
	{1, 0},
	{0, -1},
	{-1, 0},
}

func IslandPerimeter(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 1 {
				return helper(grid, i, j, m, n)
			}
		}
	}
	return 0
}

func helper(grid [][]int, i int, j int, m int, n int) int {
	grid[i][j] = -1
	result := 0
	for _, d := range dir {
		x, y := i+d[0], j+d[1]
		if x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0 {
			result++
		} else {
			if grid[x][y] == 1 {
				result += helper(grid, x, y, m, n)
			}
		}

	}
	return result
}
