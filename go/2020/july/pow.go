package july

import "math"

func myPow(x float64, n int64) float64 {
	return math.Pow(x, float64(n))
}

func _pow(x float64, n int64) float64 {
	if n < 0 {
		x = 1 / x
		n = -n
	}
	var res = 1.0
	for n > 1 {
		if (n & 1) == 1 {
			res *= x
		}
		x *= x
		n >>= 1
	}
	return res
}
