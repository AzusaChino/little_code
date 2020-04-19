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
  dummy := node
  for dummy.Next != nil {
    sb += " -> " + string(dummy.Val)
    dummy = dummy.Next
  }
  return sb
}

type Stack struct {
  table []int
}

func NewStack() *Stack {
  return &Stack{make([]int, 0)}
}

func (s *Stack) Push(v int) {
  s.table = append(s.table, v)
}

func (s *Stack) Empty() bool {
  return len(s.table) == 0
}

func (s *Stack) Pop() int {
  l := len(s.table)
  if l == 0 {
    return 0
  }

  res := s.table[l-1]
  s.table = s.table[:l-1]
  return res
}