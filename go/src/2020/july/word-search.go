package july

func exist(board [][]rune, word string) bool {
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[0]); j++ {
			if helper(board, i, j, word, 0) {
				return true
			}
		}
	}
	return false
}

func helper(board [][]rune, i int, j int, word string, index int) bool {
	if index == len(word) {
		return true
	}
	if i < 0 || j < 0 || i >= len(board) || j >= len(board[0]) || []rune(word)[index] != board[i][j] {
		return false
	}
	board[i][j] = '~'

	res := helper(board, i-1, j, word, index+1) ||
		helper(board, i+1, j, word, index+1) ||
		helper(board, i, j-1, word, index+1) ||
		helper(board, i, j+1, word, index+1)

	board[i][j] = []rune(word)[index]
	return res
}
