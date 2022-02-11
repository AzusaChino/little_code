package aug

func largestIsland(grid [][]int) int {
	var queue [][]int
	dirs := [][]int{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}
	// store the id of each island
	island := newGrid(len(grid), len(grid[0]))
	// store the area of each island
	islandArea := newGrid(len(grid), len(grid[0]))
	idx := 1 // id of island
	maxArea := 0

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == 1 {
				area := getArea(grid, dirs, &queue, i, j)
				maxArea = max(maxArea, area)
				for len(queue) > 0 {
					pos := queue[0]
					islandArea[pos[0]][pos[1]] = area
					island[pos[0]][pos[1]] = idx
					queue = queue[1:]
				}
				idx++
			}
		}
	}

	for i := 0; i < len(islandArea); i++ {
		for j := 0; j < len(islandArea[0]); j++ {
			if islandArea[i][j] == 0 {
				maxArea = max(maxArea, connectIslands(islandArea, island, dirs, i, j))
			}
		}
	}
	return maxArea
}

func connectIslands(islandArea, island, dirs [][]int, x, y int) int {
	area := 1
	connectedIslands := make(map[int]bool)
	for _, dir := range dirs {
		newX, newY := x+dir[0], y+dir[1]
		if validPos(islandArea, newX, newY) && !connectedIslands[island[newX][newY]] {
			connectedIslands[island[newX][newY]] = true
			area += islandArea[newX][newY]
		}
	}
	return area
}

func getArea(grid, dirs [][]int, queue *[][]int, x, y int) int {
	grid[x][y] = 0
	*queue = append(*queue, []int{x, y})
	area := 1

	for _, dir := range dirs {
		newX, newY := x+dir[0], y+dir[1]
		if validPos(grid, newX, newY) && grid[newX][newY] == 1 {
			area += getArea(grid, dirs, queue, newX, newY)
		}
	}

	return area
}

func validPos(grid [][]int, x, y int) bool {
	return x >= 0 && x < len(grid) && y >= 0 && y < len(grid[0])
}

func newGrid(m, n int) [][]int {
	res := make([][]int, m)
	for i := 0; i < m; i++ {
		res[i] = make([]int, n)
	}
	return res
}
