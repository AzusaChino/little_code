package apr

func minimumTotal(tri [][]int) int {
	if tri == nil {
		return 0
	}

	for row := len(tri) - 2; row >= 0; row-- {
		for col := 0; col < len(tri[row]); col++ {
			tri[row][col] += min(tri[row+1][col], tri[row+1][col+1])
		}
	}
	return tri[0][0]
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
