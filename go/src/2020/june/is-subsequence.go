package june

func is_subsequence(s string, t string) bool {
	if len(s) == 0 {
		return true
	}

	idx1, idx2 := 0, 0

	for idx2 < len(t) {
		if t[idx2] == s[idx1] {
			idx1++
			if idx1 == len(s) {
				return true
			}
		}
		idx2++
	}
	return false
}
