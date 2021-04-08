package easy

import "leetcode/common"

func addTwoNumbers(l1 *common.ListNode, l2 *common.ListNode) *common.ListNode {
	pointer := &common.ListNode{Val: 0}
	dummy := pointer

	carry := 0
	for l1 != nil || l2 != nil || carry != 0 {
		if l1 != nil {
			carry += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			carry += l2.Val
			l2 = l2.Next
		}
		pointer.Next = &common.ListNode{Val: carry % 10}
		pointer = pointer.Next
		carry /= 10
	}
	return dummy.Next
}
