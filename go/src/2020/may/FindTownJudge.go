package may

func FindJudge(n int, trust [][]int) int {
	count := make([]int, n+1)
	for _, t := range trust {
		count[t[0]]--
		count[t[1]]++
	}
	for i := 1; i <= n; i++ {
		if count[i] == n-1 {
			return i
		}
	}
	return -1
}
