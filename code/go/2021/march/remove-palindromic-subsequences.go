package march

func removePalindromeSub(s string) int {
	if len(s) == 0 {
		return 0
	}
	if s == reverseString(s) {
		return 1
	}
	return 2
}

func reverseString(s string) string {
	runes := []rune(s)
	for from, to := 0, len(runes)-1; from < to; from, to = from+1, to-1 {
		runes[from], runes[to] = runes[to], runes[from]
	}
	return string(runes)
}
