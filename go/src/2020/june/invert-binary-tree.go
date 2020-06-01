package june

import . "common"

func InvertTreeNode(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}
	left, right := root.Left, root.Right
	root.Left = InvertTreeNode(left)
	root.Right = InvertTreeNode(right)
	return root
}
