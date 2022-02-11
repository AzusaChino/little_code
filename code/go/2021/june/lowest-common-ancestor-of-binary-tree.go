package june

import "leetcode/common"

func lowestCommonAncestor(root, p, q *common.TreeNode) *common.TreeNode {
	if root == nil || root == q || root == p {
		return root
	}
	left := lowestCommonAncestor(root.Left, p, q)
	right := lowestCommonAncestor(root.Right, p, q)
	if left != nil {
		if right != nil {
			return root
		}
		return left
	}
	return right
}
