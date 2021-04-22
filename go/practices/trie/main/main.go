package main

import "leetcode/practices/trie"

func main() {
	//var t = new(trie.Trie)
	//t.Insert("hello")
	//print(t.Search("hello"))
	var board [][]rune
	var word []string
	word = append(word, "hello", "wow", "yes")
	for i := 0; i < 4; i++ {
		temp := make([]rune, 4)
		temp = append(temp, 'w', 'o', 'w', 'e')
		board = append(board, temp)
	}
	print(trie.WordSearch(board, word))
}
