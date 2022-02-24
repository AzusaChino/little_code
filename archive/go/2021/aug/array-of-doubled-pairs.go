package aug

func canReorderDoubled(arr []int) bool {
	m := make(map[int]int)
	for _, n := range arr {
		m[n]++
	}
	for k, v := range m {
		if v == 0 {
			continue
		}
		var want int
		if k < 0 {
			want = k / 2
		} else {
			want = k * 2
		}
		wv, ok := m[want]
		if !ok {
			wv = 0
		}
		if (k < 0 && k%2 != 0) || v > wv {
			return false
		}
		m[want] = m[want] - v
	}
	return true
}
