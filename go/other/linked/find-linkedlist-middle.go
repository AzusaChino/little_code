package linked

import "leetcode/common"

// 寻找linked list的middle => 可以用于反转链表
func findMiddle(root *common.ListNode) *common.ListNode {
	var fast = root
	var slow = root
	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
	}
	return slow
}
