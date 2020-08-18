package aug

import "math"

func numsSameConsecDiff(N int, K int) []int {
	if N == 1 {
		return []int{0,1,2,3,4,5,6,7,8,9}
	}
	if K == 0 {
		var ret []int
		v := 0
		for i := 0; i < N; i++ {
			v += 1 * int(math.Pow10(i))
		}
		for i := 1; i < 10; i++ {
			ret = append(ret, i*v)
		}
		return ret
	}
	ret := []int{1,2,3,4,5,6,7,8,9}
	for i := 1; i < N; i++ {
		var next []int
		for _, v := range ret {
			if v % 10 - K >= 0 {
				next = append(next, v * 10 + v % 10 - K)
			}
			if v % 10 + K <= 9 {
				next = append(next, v * 10 + v % 10 + K)
			}
		}
		ret = next
	}
	return ret
}