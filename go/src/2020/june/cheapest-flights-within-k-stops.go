package june

import "common"

func FindCheapestPrice(n int, flights [][]int, src int, dst int, k int) {
	var prices = make(map[int]map[int]int)
	for _, f := range flights {
		if prices[f[0]] == nil {
			prices[f[0]] = make(map[int]int)
		} else {
			prices[f[0]][f[1]] = f[2]
		}
	}

	pq := make(common.PriorityQueue, 9)
	pq.Push(1)

}
