package apr

func leastBricks(wall [][]int) int {
	m := make(map[int]int)
	minBricks := len(wall)

	for _, row := range wall {
		sum := 0
		for i := 0; i < len(row)-1; i++ {
			sum += row[i]
			m[sum] = m[sum] + 1
			minBricks = min(minBricks, len(wall)-m[sum])
		}
	}

	return minBricks
}
