package medium

import (
	. "common"
	"math"
)

func rob(root *TreeNode) int {
	res := dp(root)
	return int(math.Max(float64(res[0]), float64(res[1])))
}

func dp(root *TreeNode) []int {
	if root == nil {
		return []int{0, 0}
	}
	left := dp(root.Left)
	right := dp(root.Right)

	rob := root.Val + left[0] + right[0]

	notRob := int(math.Max(float64(left[0]), float64(left[1]))) +
		int(math.Max(float64(right[0]), float64(right[1])))

	return []int{notRob, rob}
}
