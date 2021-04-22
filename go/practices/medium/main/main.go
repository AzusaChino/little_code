package main

import (
	"fmt"
	. "leetcode/common"
	"leetcode/practices/medium"
)

func main() {
	coins := []int{1, 2, 5, 10}
	head := &ListNode{Val: 1,
		Next: &ListNode{Val: 2,
			Next: &ListNode{Val: 3}}}
	fmt.Println(medium.Rotate(head, 2))
	fmt.Println(medium.CoinChange3(coins, 99))
}
