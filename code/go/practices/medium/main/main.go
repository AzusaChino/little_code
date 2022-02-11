package main

import (
	"fmt"
	"leetcode/common"
	"leetcode/practices/medium"
)

func main() {
	coins := []int{1, 2, 5, 10}
	head := &common.ListNode{Val: 1,
		Next: &common.ListNode{Val: 2,
			Next: &common.ListNode{Val: 3}}}
	fmt.Println(medium.Rotate(head, 2))
	fmt.Println(medium.CoinChange3(coins, 99))
}
