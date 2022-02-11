package july

import (
	. "leetcode/common"
)

func bfs(s *[][]int, level int, root *TreeNode) {
	if root == nil {
		return
	}

	if len(*s) == level {
		*s = append(*s, []int{})
	}

	if level%2 == 1 {
		(*s)[level] = append([]int{root.Val}, (*s)[level]...)
	} else {
		(*s)[level] = append((*s)[level], root.Val)
	}
	for _, v := range []*TreeNode{root.Left, root.Right} {
		bfs(s, level+1, v)
	}
}

func zigzagLevelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	var s [][]int
	bfs(&s, 0, root)
	return s
}
