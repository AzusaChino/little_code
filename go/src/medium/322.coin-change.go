package medium

import "math"

func CoinChange1(coins []int, amount int) int {
	return helper1(coins, amount)
}

func helper1(coins []int, n int) int {
	if n == 0 {
		return 0
	}
	if n < 0 {
		return -1
	}
	res := math.MaxInt64
	for _, c := range coins {
		sub := helper1(coins, n-c)
		if sub == -1 {
			continue
		}
		res = int(math.Min(float64(sub+1), float64(res)))
	}
	if res == math.MaxInt64 {
		return -1
	} else {
		return res
	}
}

func CoinChange2(coins []int, amount int) int {
	m := make(map[int]int, amount+1)
	return helper2(m, coins, amount)
}

func helper2(m map[int]int, coins []int, n int) int {
	if v, ok := m[n]; ok {
		return v
	}
	if n == 0 {
		return 0
	}
	if n < 0 {
		return -1
	}
	res := math.MaxInt64
	for _, c := range coins {
		sub := helper1(coins, n-c)
		if sub == -1 {
			continue
		}
		m[n] = int(math.Min(float64(sub+1), float64(res)))
	}
	if m[n] == math.MaxInt64 {
		return -1
	} else {
		return m[n]
	}
}

func CoinChange3(coins []int, amount int) int {
	dp := make([]int, amount+1)
	for i := range dp {
		dp[i] = amount + 1
	}
	dp[0] = 0
	for i := range dp {
		for _, c := range coins {
			if i-c < 0 {
				continue
			}
			dp[i] = int(math.Min(float64(dp[i]), float64(i+dp[i-c])))
		}
	}
	if dp[amount] == amount+1 {
		return -1
	} else {
		return dp[amount]
	}
}
