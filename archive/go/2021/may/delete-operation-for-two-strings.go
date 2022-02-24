package may

func minDistance(word1 string, word2 string) int {
	l1, l2 := len(word1), len(word2)
	return l1 + l2 - 2*lcs(word1, word2, l1, l2)
}

func lcs(s1, s2 string, l1, l2 int) int {
	if l1 == 0 || l2 == 0 {
		return 0
	}
	if s1[l1-1] == s2[l2-1] {
		return 1 + lcs(s1, s2, l1-1, l2-1)
	} else {
		return max(lcs(s1, s2, l1, l2-1), lcs(s1, s2, l1-1, l2))
	}
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
