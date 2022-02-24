package aug

import "leetcode/common"

func sum(root *common.TreeNode) int {
	return helper2(root, false)

}

func helper2(root *common.TreeNode, isLeft bool) int {
	if root == nil {
		return 0
	}
	if root.Left != nil && root.Right != nil {
		if isLeft {
			return root.Val
		} else {
			return 0
		}
	}
	return helper2(root.Left, true) + helper2(root.Right, false)
}
