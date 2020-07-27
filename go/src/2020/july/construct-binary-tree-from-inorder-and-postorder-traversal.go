package july

import (
	. "common"
)

func inpost_buildTree(inorder []int, in_begin int, in_end int, postorder []int, root_pos int) *TreeNode {
	if root_pos < 0 || in_begin > in_end {
		return nil
	}
	//find root's position in inorder
	var i = in_begin
	for i < in_end && inorder[i] != postorder[root_pos] {
		i++
	}
	var node TreeNode
	node.Val = postorder[root_pos]
	node.Left = inpost_buildTree(inorder, in_begin, i-1, postorder, root_pos-in_end+i-1)
	node.Right = inpost_buildTree(inorder, i+1, in_end, postorder, root_pos-1)
	return &node
}

func buildTree(inorder []int, postorder []int) *TreeNode {
	lin := len(inorder)
	lpost := len(postorder)
	if lin == 0 || lpost == 0 || lin != lpost {
		return nil
	}
	return inpost_buildTree(inorder, 0, lin-1, postorder, lpost-1)
}
