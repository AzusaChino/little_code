package backtrack

func SudokuSolver(board [][]rune) {
	if board == nil || len(board) == 0 {
		return
	}
	solve(board)
}

func solve(board [][]rune) bool {
	m, n := len(board), len(board[0])
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if board[i][j] != '.' {
				for k := '1'; k <= '9'; k++ {
					if valid(board, i, j, k) {
						board[i][j] = k
						if solve(board) {
							return true
						} else {
							board[i][j] = '.'
						}
					}

				}
				return false

			}
		}
	}
	return true
}

func valid(board [][]rune, row int, col int, c rune) bool {
	for i := 1; i <= 9; i++ {
		if board[row][i] == c {
			return false
		}
		if board[i][j] == c {
			return false
		}
		if board[3*(row/3)+i/3][3*(col/3)+i%3] == c {
			return false
		}
	}
	return true
}
