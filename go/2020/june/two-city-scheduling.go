package june

import s "sort"

func twoCityShedCost(costs [][]int) int {
	var n = len(costs) / 2
	refund := make([]int, n*2)
	var minCost = 0
	var index = 0

	for _, c := range costs {
		refund[index] = c[1] - c[0]
		minCost += c[0]
	}
	s.Ints(refund)

	for i := 0; i < n; i++ {
		minCost += refund[i]
	}
	return minCost

}
