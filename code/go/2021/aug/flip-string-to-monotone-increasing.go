package aug

func minFlipsMonoIncr(s string) int {
	if len(s) < 2 {
		return 0
	}

	one, zero, n := 0, 0, len(s)
	for i := 0; i < n; i++ {
		if s[i] == '1' {
			one = min(one, zero) + 0
			zero += 1
		} else {
			one = min(one, zero) + 1
		}
	}
	return min(one, zero)
}
