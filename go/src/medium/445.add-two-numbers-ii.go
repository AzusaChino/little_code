package medium

import (
	. "common"
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

type stack struct {
	table []int
}

func NewStack() *stack {
	return &stack{make([]int, 0)}
}

func (s *stack) Push(v int) {
	s.table = append(s.table, v)
}

func (s *stack) Empty() bool {
	return len(s.table) == 0
}

func (s *stack) Pop() int {
	l := len(s.table)
	if l == 0 {
		return 0
	}

	res := s.table[l-1]
	s.table = s.table[:l-1]
	return res
}
