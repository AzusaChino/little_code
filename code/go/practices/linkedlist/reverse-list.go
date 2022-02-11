package linkedlist

import "leetcode/common"

func reverseList(head *common.ListNode) *common.ListNode {
	if head.Next == nil {
		return head
	}
	last := reverseList(head.Next)
	head.Next.Next = head
	head.Next = nil
	return last
}
