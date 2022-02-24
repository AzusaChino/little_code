package may

func longestStrChain(words []string) int {
	data := make([]map[string]int, 17)
	for _, w := range words {
		if data[len(w)] == nil {
			data[len(w)] = make(map[string]int)
		}
		data[len(w)][w] = 1
	}
	longestChain := 1
	for i := 15; i >= 1; i-- {
		for s1 := range data[i] {
			for s2 := range data[i+1] {
				if chain(s1, s2) {
					data[i][s1] = max(data[i][s1], data[i+1][s2]+1)
					longestChain = max(data[i][s1], longestChain)
				}
			}
		}
	}
	return longestChain
}

func chain(s1, s2 string) bool {
	l, r := 0, len(s2)-1
	for l < r {
		if s1[l] == s2[l] {
			l++
			continue
		}
		if s1[r-1] == s2[r] {
			r--
			continue
		}
		return false
	}
	return true
}
