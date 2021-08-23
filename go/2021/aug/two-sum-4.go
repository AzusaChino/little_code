package aug

import (
	. "leetcode/common"
	"sync/atomic"
)

type Lock uint32

var l = new(Lock)

func findTarget(root *TreeNode, k int) bool {

	m := make(map[int]interface{})
	helper(root, m, k)
	return atomic.LoadUint32((*uint32)(l)) == 1
}

func helper(node *TreeNode, m map[int]interface{}, k int) {
	if node == nil {
		return
	}
	if _, ok := m[node.Val]; ok {
		atomic.StoreUint32((*uint32)(l), 1)
		return
	}
	m[k-node.Val] = node.Val
	helper(node.Left, m, k)
	helper(node.Right, m, k)
}

func findTarget_(root *TreeNode, k int) bool {
	m := make(map[int]int, 0)
	return findTargetDFS(root, k, m)
}

func findTargetDFS(root *TreeNode, k int, m map[int]int) bool {
	if root == nil {
		return false
	}
	if _, ok := m[k-root.Val]; ok {
		return ok
	}
	m[root.Val]++
	return findTargetDFS(root.Left, k, m) || findTargetDFS(root.Right, k, m)
}
