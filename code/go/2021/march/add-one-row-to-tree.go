package march

import "leetcode/common"

func addOneRow(root *common.TreeNode, v int, d int) *common.TreeNode {
	if d == 0 || d == 1 {
		var newRoot = common.TreeNode{Val: v}
		if d == 1 {
			newRoot.Left = root
		} else {
			newRoot.Left = nil
		}
		if d == 0 {
			newRoot.Right = root
		} else {
			newRoot.Right = nil
		}
		return &newRoot
	}
	if root != nil && d >= 2 {
		var l, r int
		if d > 2 {
			l = d - 1
			r = d - 1
		} else {
			l = 1
			r = 0
		}
		root.Left = addOneRow(root.Left, v, l)
		root.Right = addOneRow(root.Right, v, r)
	}
	return root
}
