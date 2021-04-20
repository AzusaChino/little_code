package apr

type Node struct {
	Val      int
	Children []*Node
}

func preorder(root *Node) []int {
	var result []int
	helper(root, &result)
	return result
}

func helper(root *Node, result *[]int) {
	if root != nil {
		*result = append(*result, root.Val)
		if root.Children != nil && len(root.Children) > 0 {
			for _, c := range root.Children {
				helper(c, result)
			}
		}
	}
}
