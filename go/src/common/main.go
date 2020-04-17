package common

type TreeNode struct {
  Val int
  Left *TreeNode
  Right *TreeNode
}

type ListNode struct {
  Val int
  Next *ListNode
}

func (node *ListNode) String() string{
  sb := ""
  for node.Next != nil {
    sb += " -> " + string(node.Val)
    node = node.Next
  }
  return sb
}