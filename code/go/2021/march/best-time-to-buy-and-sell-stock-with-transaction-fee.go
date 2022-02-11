package march

func maxProfit(prices []int, fee int) int {
	if len(prices) <= 1 {
		return 0
	}
	var days = len(prices)
	var buy = make([]int, days)
	var sell = make([]int, days)
	buy[0] = -prices[0]
	for i := 1; i < days; i++ {
		buy[i] = max(buy[i-1], sell[i-1]-prices[i])
		sell[i] = max(sell[i-1], buy[i-1]+prices[i]-fee)
	}
	return sell[days-1]
}

func max(a, b int) int {
	if a >= b {
		return a
	}
	return b
}
