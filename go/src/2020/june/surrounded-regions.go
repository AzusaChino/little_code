package june

func solve(board [][]rune) {
	if len(board) == 0 || len(board[0]) == 0 {
		return
	}
	if len(board) < 3 || len(board[0]) < 3 {
		return
	}
	m, n := len(board), len(board[0])
	for i := 0; i < m; i++ {
		// up
		if board[i][0] == 'O' {
			_helper(board, i, 0)
		}
		// bottom
		if board[i][n-1] == 'O' {
			_helper(board, i, n-1)
		}
	}

	for j := 1; j < n-1; j++ {
		// left
		if board[0][j] == 'O' {
			_helper(board, 0, j)
		}
		// right
		if board[m-1][j] == 'O' {
			_helper(board, m-1, j)
		}
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if board[i][j] == 'O' {
				board[i][j] = 'X'
			}
			if board[i][j] == '*' {
				board[i][j] = 'O'
			}
		}
	}
}

func _helper(board [][]rune, r int, c int) {
	if r < 0 || c < 0 || r > len(board)-1 || c > len(board[0])-1 || board[r][c] != 'O' {
		return
	}
	board[r][c] = '*'
	_helper(board, r+1, c)
	_helper(board, r-1, c)
	_helper(board, r, c+1)
	_helper(board, r, c-1)
}
