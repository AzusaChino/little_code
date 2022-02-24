package linkedlist

import "leetcode/common"

func hasCycle(root *common.ListNode) bool {
	var fast = root
	var slow = root
	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
		if slow == fast {
			return true
		}
	}
	return false
}
