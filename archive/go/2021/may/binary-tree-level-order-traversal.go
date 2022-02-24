package may

import . "leetcode/common"

func levelOrder(root *TreeNode) [][]int {
	if root == nil {
		return [][]int{}
	}
	var res [][]int
	queue := []*TreeNode{root}
	for level := 0; len(queue) > 0; level++ { //level - to track where we need to insert values
		res = append(res, []int{}) //adding slice for the new "level" of values
		for levelSize := len(queue); levelSize > 0; levelSize-- {
			//levelSize - to track how many elements we need to dequeue and insert in the current "level"
			if queue[0].Left != nil {
				queue = append(queue, queue[0].Left)
			} //adding next nodes to the queue
			if queue[0].Right != nil {
				queue = append(queue, queue[0].Right)
			}
			res[level] = append(res[level], queue[0].Val) //adding first element in the queue to a "level" slice
			queue = queue[1:]                             //deque first element
		}
	}
	return res
}
