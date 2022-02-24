package july

import "leetcode/common"

func sortedArrayToBST(nums []int) *common.TreeNode {
	if len(nums) == 0 {
		return nil
	}
	return &common.TreeNode{Val: nums[len(nums)/2], Left: sortedArrayToBST(nums[:len(nums)/2]), Right: sortedArrayToBST(nums[len(nums)/2+1:])}
}
