package aug

func generate(numRows int) [][]int {
	s := make([][]int, numRows)
	if numRows == 0 {
		return s
	}
	for i := 1; i <= numRows; i++ {
		s[i-1] = make([]int, i)
		s[i-1][0] = 1
		s[i-1][i-1] = 1
		if i-1 > 1 {
			for j := 1; j < i-1; j++ {
				s[i-1][j] = s[i-2][j-1] + s[i-2][j]
			}
		}
	}
	return s
}

func generate2(numRows int) [][]int {
	if numRows == 0 {
		return [][]int{}
	} else if numRows == 1 {
		return [][]int{{1}}
	}

	rows := [][]int{{1}, {1, 1}}
	for i := 2; i < numRows; i++ {
		lastRow := rows[len(rows)-1]
		newRow := make([]int, len(lastRow)+1)
		for j := 0; j < len(newRow); j++ {
			if j == 0 || j == len(newRow)-1 {
				newRow[j] = 1
				continue
			}
			newRow[j] = lastRow[j] + lastRow[j-1]
		}
		rows = append(rows, newRow)
	}
	return rows
}
