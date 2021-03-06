package july

func wordBreak1(s string, dict []string) bool {
	dp := make([]bool, len(s)+1)
	dp[0] = true

	for i := range s {
		if !dp[i] {
			continue
		}

		for _, word := range dict {
			if i+len(word) > len(s) {
				continue
			}

			if s[i:i+len(word)] == word {
				dp[i+len(word)] = true
			}
		}
	}

	return dp[len(s)]

}
