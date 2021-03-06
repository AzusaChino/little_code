package march

// 820. Short Encoding of Words

func minimumLengthEncoding(words []string) int {
	m := make(map[string]struct{})
	for _, w := range words {
		m[w] = struct{}{}
	}

	for k := range m {
		for i := 1; i < len(k); i++ {
			delete(m, k[i:])
		}
	}
	ret := 0
	for k := range m {
		ret += len(k) + 1
	}
	return ret
}
