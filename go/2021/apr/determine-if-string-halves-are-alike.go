package apr

import "strings"

func halvesAreAlike(s string) bool {
	s = strings.ToLower(s)
	m := len(s) / 2
	sl, sr := s[:m], s[m:]
	mp := make(map[rune]struct{})
	sli := []rune{'a', 'i', 'u', 'e', 'o'}
	for _, c := range sli {
		mp[c] = struct{}{}
	}
	il, ir := 0, 0
	for _, c := range sl {
		if _, ok := mp[c]; ok {
			il++
		}
	}
	for _, c := range sr {
		if _, ok := mp[c]; ok {
			ir++
		}
	}
	return il == ir
}
