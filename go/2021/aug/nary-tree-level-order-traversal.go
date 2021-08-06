package aug

type Node struct {
	Val      int
	Children []*Node
}

var ans [][]int

func levelOrder(root *Node) [][]int {
	dfs(root, 0)
	return ans
}

func dfs(root *Node, lv int) {
	if root == nil {
		return
	}
	if lv == len(ans) {
		ans = append(ans, []int{})
	}
	ans[lv] = append(ans[lv], root.Val)
	for _, child := range root.Children {
		dfs(child, lv+1)
	}
}
