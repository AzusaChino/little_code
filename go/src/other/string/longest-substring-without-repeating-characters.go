package string

import "math"

func longest(s string) int {
	window := make(map[rune]int)

	left, right, ret := 0, 0, 0

	for right < len(s) {
		c := rune(s[right])
		right++
		window[c]++
		// meet duplicate => pop left
		for window[c] > 1 {
			d := rune(s[left])
			left++
			window[d]--
		}
		ret = int(math.Max(float64(ret), float64(right-left)))
	}
	return ret
}
