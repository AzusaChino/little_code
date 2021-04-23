package apr

func countBinarySubstrings(s string) int {
	cur, pre, res := 1, 0, 0
	for i := 1; i < len(s); i++ {
		if s[i] == s[i-1] {
			cur++
		} else {
			res = min(cur, pre)
			pre = cur
			cur = 1
		}
	}
	return res + min(cur, pre)
}
