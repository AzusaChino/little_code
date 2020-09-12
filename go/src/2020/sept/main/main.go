package main

import "2020/sept"

func main() {
	var candidates = []int{
		2, 3, 6, 7,
	}
	ret := sept.CombinationSum(candidates, 7)
	for _, x := range ret {
		print(x)
	}
}
