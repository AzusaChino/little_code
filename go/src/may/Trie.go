package may

type TrieNode struct {
	isWord bool
	children []TrieNode
}

type Trie struct {
	root TrieNode
}

func (t Trie) insert(word string) {

}
