package trie

func WordSearch(board [][]rune, words []string) []string {
	if len(board) == 0 || len(board[0]) == 0 || len(words) == 0 {
		return nil
	}
	trie := new(Trie)
	for _, word := range words {
		trie.Insert(word)
	}
	var ret []string
	var visited [][]bool
	m, n := len(board), len(board[0])

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if trie.Children[board[i][j]-'a'] != nil {
				dfs(board, ret, visited, "", i, j, trie)
			}
		}
	}
	return ret
}

func dfs(board [][]rune, ret []string, visited [][]bool, s string, x int, y int, trie *Trie) {
	if x < 0 || x >= len(board) || y < 0 || y >= len(board[0]) || visited[x][y] {
		return
	}
	s = string(append([]rune(s), board[x][y]))
	if !trie.StartsWith(s) {
		return
	}
	if trie.Search(s) {
		ret = append(ret, s)
	}
	visited[x][y] = true
	dfs(board, ret, visited, s, x+1, y, trie)
	dfs(board, ret, visited, s, x-1, y, trie)
	dfs(board, ret, visited, s, x, y+1, trie)
	dfs(board, ret, visited, s, x, y-1, trie)
	visited[x][y] = false

}
