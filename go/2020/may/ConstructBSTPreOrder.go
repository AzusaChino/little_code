package may

import (
	. "leetcode/common"
)

func bstFromPreorder(preorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}

	rootVal := preorder[0]
	rIndex := len(preorder)

	for i := range preorder {
		if rootVal < preorder[i] {
			rIndex = i
			break
		}
	}

	return &TreeNode{
		Val:   rootVal,
		Left:  bstFromPreorder(preorder[1:rIndex]),
		Right: bstFromPreorder(preorder[rIndex:]),
	}
}
