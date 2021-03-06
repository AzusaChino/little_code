package medium

import (
	. "leetcode/common"
)

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	s1 := NewStack()
	s2 := NewStack()

	for l1 != nil {
		s1.Push(l1.Val)
		l1 = l1.Next
	}
	for l2 != nil {
		s2.Push(l2.Val)
		l2 = l2.Next
	}
	var res = &ListNode{}
	first := true
	carry := 0

	for !s1.Empty() || !s2.Empty() || carry != 0 {
		if !s1.Empty() {
			carry += s1.Pop()
		}
		if !s2.Empty() {
			carry += s2.Pop()
		}
		dummy := &ListNode{Val: carry % 10}
		if first {
			dummy.Next = nil
			first = false
		} else {
			dummy.Next = res
		}
		res = dummy
		carry /= 10
	}
	return res
}
