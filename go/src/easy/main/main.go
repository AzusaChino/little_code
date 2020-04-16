package main

import "fmt"

func main() {
	dp := []int{1, 2, 3, 4, 5}

	// iterate value
	for _, v := range dp {
		fmt.Println(v)
	}

	// iterate index
	for i := range dp {
		fmt.Println(i)
	}
	m := map[int]int{
		1: 2,
	}
	m2 := make(map[int]int, 10)
	fmt.Println(m, m2)
}
