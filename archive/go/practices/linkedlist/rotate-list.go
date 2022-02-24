package linkedlist

import . "leetcode/common"

func rotateRight(head *ListNode, k int) *ListNode {
	run := head
	var l = 0
	for run != nil {
		l++
		run = run.Next
	}
	k = k / l
	run = head
	var p ListNode
	for i := 0; i < l-k; i++ {
		run = run.Next
	}
	p = *run
	for run.Next != nil {
		var tmp = run.Next
		run.Next = &p
		p = *run
		run = tmp
	}
	return &p
}

func _rotateRight(head *ListNode, k int) *ListNode {
	if head == nil || head.Next == nil || k == 0 {
		return head
	}
	var l = 1
	var newH, tail *ListNode
	newH, tail = head, head
	for tail.Next != nil {
		tail = tail.Next
		l++
	}
	// make linked list circular
	tail.Next = head
	if (k % l) != 0 {
		// find the rotation point
		for i := 0; i < l-k; i++ {
			tail = tail.Next
		}
	}
	newH = tail.Next
	tail.Next = nil
	return newH
}
