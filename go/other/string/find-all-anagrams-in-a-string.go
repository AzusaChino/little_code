package string

func AllAnagrams(s string, p string) []int {
	target, window := make(map[rune]int), make(map[rune]int)
	for _, c := range p {
		target[c]++
	}
	left, right, valid := 0, 0, 0
	var ret []int
	for right < len(s) {
		c := rune(s[right])
		right++
		if target[c] > 0 {
			window[c]++
			if target[c] == window[c] {
				valid++
			}
		}
		for right-left >= len(p) {
			// len(target) <= len(p) => 因为可能有重复数据
			if valid == len(target) {
				ret = append(ret, left)
			}
			d := rune(s[left])
			left++
			if target[d] > 0 {
				if target[d] == window[d] {
					valid--
				}
				window[d]--
			}
		}
	}
	return ret
}
