package string

func longestPalindrome(s string) string {
	if len(s) == 0 {
		return ""
	}
	begin, maxLen, n := 0, 0, len(s)
	for i := 0; i < n-maxLen/2; i++ {
		j, k := i, i
		for k < n-1 && s[k] == s[k+1] {
			k++
		}
		for j > 0 && k < n-1 && s[j-1] == s[k+1] {
			j--
			k++
		}
		if k-j+1 > maxLen {
			begin = j
			maxLen = k - j + 1
		}
	}
	return s[begin : begin+maxLen]
}

func isPalindrome(s string) bool {
	l, r := 0, len(s)-1
	for l <= r {
		if s[l] != s[r] {
			return false
		}
		l++
		r--
	}
	return true
}
