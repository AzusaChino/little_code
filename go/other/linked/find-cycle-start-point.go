package linked

import "leetcode/common"

func findPoint(head *common.ListNode) *common.ListNode {
	var fast = head
	var slow = head
	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
		if fast == slow {
			break
		}
	}
	slow = head
	for fast != slow {
		fast = fast.Next
		slow = slow.Next
	}
	return slow
}
