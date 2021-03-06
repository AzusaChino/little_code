package backtrack

func combinationSum(candidates []int, target int) [][]int {
	var ret [][]int
	var temp []int
	dfs(ret, temp, candidates, target, 0)
	return ret
}

func dfs(list [][]int, temp []int, candidates []int, target int, start int) {
	if target < 0 {
		return
	}
	if target == 0 {
		list = append(list, temp[:])
		return
	}
	for i := start; i < len(candidates); i++ {
		temp = append(temp, candidates[i])
		dfs(list, temp, candidates, target-candidates[i], i)
		temp = temp[:len(temp)-1]
	}
}
