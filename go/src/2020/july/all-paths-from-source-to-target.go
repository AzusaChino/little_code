package july

func all_paths(graph [][]int) [][]int {

	var res = [][]int{}
	dfs(graph, 0, res, []int{0})
	return res
}

func dfs(graph [][]int, cur int, res [][]int, path []int) {
	if cur == len(graph)-1 {
		res = append(res, path)
		return
	}
	for _, next := range graph[cur] {
		path = append(path, next)
		dfs(graph, next, res, path)
		path = path[0 : len(path)-1]
	}
}
