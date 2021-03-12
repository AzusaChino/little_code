package march

// Using sliding window to traverse all possible binary codes of size k, put them into a set, then check if its size is 2 ^ k.
func hasAllCodes(s string, k int) bool {
	m := make(map[string]struct{})
	for i := k; i <= len(s) && len(m) < 1<<k; i++ {
		m[s[i-k:i]] = struct{}{}
	}
	return len(m) == 1<<k
}
