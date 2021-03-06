package june

func reverseString(s []rune) {
	helper(s, 0, len(s)-1)
}

func helper(s []rune, l int, r int) {
	if l == r || l-r == 1 {
		return
	}
	s[l], s[r] = s[r], s[l]
	helper(s, l+1, r-1)
}
