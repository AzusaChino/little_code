package may

import "leetcode/common"

// TreeNode define
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 依次把链表的中间点作为根结点，类似二分的思想，递归排列所有结点
func sortedListToBST(head *common.ListNode) *TreeNode {
	if head == nil {
		return nil
	}
	if head != nil && head.Next == nil {
		return &TreeNode{Val: head.Val, Left: nil, Right: nil}
	}
	middleNode, preNode := middleNodeAndPreNode(head)
	if middleNode == nil {
		return nil
	}
	if preNode != nil {
		preNode.Next = nil
	}
	if middleNode == head {
		head = nil
	}
	return &TreeNode{Val: middleNode.Val, Left: sortedListToBST(head), Right: sortedListToBST(middleNode.Next)}
}

func middleNodeAndPreNode(head *common.ListNode) (middle *common.ListNode, pre *common.ListNode) {
	if head == nil || head.Next == nil {
		return nil, head
	}
	p1 := head
	p2 := head
	for p2.Next != nil && p2.Next.Next != nil {
		pre = p1
		p1 = p1.Next
		p2 = p2.Next.Next
	}
	return p1, pre
}
