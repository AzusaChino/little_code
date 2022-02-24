package july

func beautifulArray(n int) []int {

	var out = make([]int, n)
	if n <= 0 {
		return out
	} else if n == 1 {
		out[0] = 1
		return out
	} else if n == 2 {
		out[0], out[1] = 1, 2
		return out
	}
	mid := n / 2
	if n%2 == 0 {
		tmp := beautifulArray(mid)
		for i := 0; i < mid; i++ {
			out[i] = tmp[i]*2 - 1
			out[i+mid] = tmp[i] * 2
		}
	} else {
		tmp1 := beautifulArray(mid)
		for i := 0; i < mid; i++ {
			out[i+mid+1] = tmp1[i] * 2
		}
		tmp2 := beautifulArray(mid + 1)
		for i := 0; i < mid+1; i++ {
			out[i] = tmp2[i]*2 - 1
		}
	}
	return out
}
