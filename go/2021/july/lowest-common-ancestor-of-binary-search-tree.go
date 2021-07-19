package july

import "leetcode/common"

func lowest(root, p, q *common.TreeNode) *common.TreeNode {
	if p == nil || q == nil || root == nil {
		return nil
	}
	if p.Val < root.Val && q.Val < root.Val {
		return lowest(root.Left, p, q)
	}
	if p.Val > root.Val && q.Val > root.Val {
		return lowest(root.Right, p, q)
	}
	return root
}
