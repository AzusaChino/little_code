package trie

type Trie struct {
	Children [26]*Trie
	IsWord   bool
}

func (trie *Trie) Insert(word string) {
	node := trie
	for i := 0; i < len(word); i++ {
		c := word[i]
		if node.Children[c-'a'] == nil {
			node.Children[c-'a'] = new(Trie)
		}
		node = node.Children[c-'a']
	}
	node.IsWord = true
}

func (trie *Trie) Search(word string) bool {
	node := trie
	for i := 0; i < len(word); i++ {
		c := word[i]
		if node.Children[c-'a'] == nil {
			return false
		}
		node = node.Children[c-'a']
	}
	return node.IsWord
}

func (trie *Trie) StartsWith(word string) bool {
	node := trie
	for i := 0; i < len(word); i++ {
		c := word[i]
		if node.Children[c-'a'] == nil {
			return false
		}
		node = node.Children[c-'a']
	}
	return true
}
