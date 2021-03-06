package linked

import . "leetcode/common"

const TEN = 10

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	// 复制数据
	c1, c2 := l1, l2
	// 返回值的list
	head := &ListNode{Val: 0}
	// 获取dummy, 进行遍历
	dummy := head
	var sum = 0

	// 循环遍历
	for c1 != nil || c2 != nil {
		// 每次只取十位
		sum /= TEN
		if c1 != nil {
			sum += c1.Val
			c1 = c1.Next
		}
		if c2 != nil {
			sum += c2.Val
			c2 = c2.Next
		}
		// 每次取个位
		dummy.Next = &ListNode{Val: sum % TEN}
		dummy = dummy.Next
	}
	// 如果最后的和 = 10 => sum余1
	if sum/TEN == 1 {
		dummy.Next = &ListNode{Val: 1}
	}
	return head.Next
}
