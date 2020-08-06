package aug

type WordDictionary struct {
	m map[byte]*WordDictionary
}

func NewWordDictionary() WordDictionary {
	return WordDictionary{
		m: make(map[byte]*WordDictionary),
	}
}

func (wd *WordDictionary) AddWord(word string) {
	current := wd
	for i := 0; i < len(word); i++ {
		w := word[i]
		if v, ok := current.m[w]; ok {
			current = v
		} else {
			current.m[w] = &WordDictionary{m: make(map[byte]*WordDictionary)}
			current = current.m[w]
		}
	}
	// represents the end of the string
	current.m['$'] = &WordDictionary{m: make(map[byte]*WordDictionary)}
}

func (wd *WordDictionary) Search(word string) bool {
	return search(word, wd)
}

func search(word string, current *WordDictionary) bool {
	if len(word) == 0 {
		return false
	}
	if word[0] == '.' {
		for _, v := range current.m {
			if v.m['$'] != nil && len(word) == 1 {
				return true
			}
			if search(word[1:], v) {
				return true
			}
		}
	} else {
		if v, ok := current.m[word[0]]; ok {
			if v.m['$'] != nil && len(word) == 1 {
				return true
			} else {
				return search(word[1:], v)
			}
		}
	}
	return false
}
