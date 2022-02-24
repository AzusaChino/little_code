package aug

import (
	"strings"
	"unicode"
)

func Reverse(s string) string {
	n := len(s)
	runes := make([]rune, n)
	for _, r := range s {
		n--
		runes[n] = r
	}
	return string(runes[n:])
}

func isPalindrome(s string) bool {
	isAlphabet := func(r rune) rune {
		if unicode.IsLetter(r) || unicode.IsNumber(r) {
			return r
		}
		return -1
	}
	s2 := strings.ToLower(strings.Map(isAlphabet, s))
	return s2 == Reverse(s2)
}
