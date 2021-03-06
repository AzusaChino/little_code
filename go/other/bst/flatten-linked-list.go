package bst

func Flatten(root *TreeNode) *TreeNode {
	cur := root
	for cur != nil {
		if cur.Left != nil {
			last := cur.Left
			for last.Right != nil {
				last = last.Right
			}
			last.Right = cur.Right
			cur.Right = cur.Left
			cur.Left = nil
		}
		cur = cur.Right
	}
	return nil
}
