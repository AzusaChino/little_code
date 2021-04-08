package linkedlist

import "leetcode/common"

func findKthPostElement(root *common.ListNode, k int) *common.ListNode {

	var fast = root
	var slow = root
	// case for k not large than linkedlist list
	for k > 0 {
		k--
		fast = fast.Next
	}
	for fast != nil {
		fast = fast.Next
		slow = slow.Next
	}
	return slow
}

func findKthPostElement2(root *common.ListNode, k int) *common.ListNode {

	var node = root
	var size = 0
	for node != nil {
		node = node.Next
		size++
	}
	// 求出余数
	k = size % k

	var fast = root
	var slow = root

	for k > 0 {
		k--
		fast = fast.Next
	}
	for fast != nil {
		fast = fast.Next
		slow = slow.Next
	}
	return slow
}
