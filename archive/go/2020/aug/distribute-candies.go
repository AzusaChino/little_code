package aug

import "math"

func Distribute(candies int, num int) (distributes []int) {
	var res = make([]int, num)
	for i := 0; candies > 0; candies -= i {
		i += 1
		res[i%num] += int(math.Min(float64(candies), float64(i)))
	}
	return res
}
