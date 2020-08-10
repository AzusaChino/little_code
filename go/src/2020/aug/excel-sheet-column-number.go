package aug

import "math"

func titleToNumber(s string) int {
	var (
		r int
		p int
	)
	b := []byte(s)

	for len(b) > 0 {
		r += (int(b[len(b) - 1] - 'A') + 1) * int(math.Pow(26, float64(p)))
		p++
		b = b[:len(b) - 1]
	}
	return r
}