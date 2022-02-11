package main

import (
	"fmt"
	"leetcode/2020/sept"
)

func main() {
	var candidates = []int{
		2, 3, 6, 7,
	}
	ret := sept.CombinationSum(candidates, 7)
	for _, x := range ret {
		fmt.Println(x)
	}
	var grid = [][]int{
		{1, 0, 0, 0},
		{0, 0, 0, 0},
		{0, 0, 0, 2}}
	ret2 := sept.UniquePaths3(grid)
	fmt.Println(ret2)
}
