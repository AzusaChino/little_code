package aug

import . "leetcode/common"

var (
	res   = 0
	total = 0
	sub   int
)

func maxProduct(root *TreeNode) int {
	total = s(root)
	s(root)
	return (int)(res % (int)(1e9+7))
}

func s(node *TreeNode) int {
	if node != nil {
		sub = node.Val + s(node.Left) + s(node.Right)
		res = max(res, sub*(total-sub))
		return sub
	}
	return 0
}
