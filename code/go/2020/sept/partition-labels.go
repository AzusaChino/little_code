package sept

import "math"

func PartitionLabel(s string) []int {

	var ret []int
	dict := make([]int, 26)
	for i := 0; i < len(s); i++ {
		dict[s[i]-'a'] = i
	}

	start, last := 0, 0
	for i := 0; i < len(s); i++ {
		last = int(math.Max(float64(last), float64(dict[s[i]-'a'])))
		if last == i {
			ret = append(ret, last-start+1)
			start = last + 1
		}
	}
	return ret
}
