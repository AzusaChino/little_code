package sept

import . "leetcode/common"

func reverseList(head *ListNode) *ListNode {
	var last *ListNode
	for head != nil {
		next := head.Next
		head.Next = last
		last = head
		head = next
	}
	return last
}
