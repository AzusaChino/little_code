package july

import "math"

func maxProfits(prices []int) int {
	free := 0
	have, cool := math.MinInt64, math.MinInt64
	for _, p := range prices {
		free, have, cool = int(math.Max(float64(free), float64(cool))), int(math.Max(float64(have), float64(free-p))), have+p
	}

	return int(math.Max(float64(free), float64(cool)))
}
