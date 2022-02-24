package sept

import "leetcode/common"

func sumRootToLeaf(root *common.TreeNode) int {
	return dfs(root, 0)
}

func dfs(root *common.TreeNode, val int) int {
	if root == nil {
		return 0
	}
	val = val*2 + root.Val
	if root.Left == root.Right {
		return val
	}
	return dfs(root.Left, val) + dfs(root.Right, val)
}
