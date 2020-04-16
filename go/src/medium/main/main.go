package main

import (
	"fmt"
	"medium"
)

func main() {
	coins := []int{1, 2, 5, 10}

	fmt.Println(medium.CoinChange3(coins, 99))
}
