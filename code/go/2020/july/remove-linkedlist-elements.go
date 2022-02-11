package july

import "leetcode/common"

func removeElements(head *common.ListNode, val int) *common.ListNode {
	if head == nil {
		return nil
	}
	head.Next = removeElements(head.Next, val)
	if head.Val == val {
		return head.Next
	} else {
		return head
	}
}
