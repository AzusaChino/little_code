package aug

import "sort"

type ByLength [][]int

func (s ByLength) Len() int {
	return len(s)
}
func (s ByLength) Swap(i, j int) {
	s[i], s[j] = s[j], s[i]
}
func (s ByLength) Less(i, j int) bool {
	return s[i][0] < s[j][0]
}

func findRightInterval(intervals [][]int) []int {
	original := make(map[int]int)
	for i, _ := range intervals {
		original[intervals[i][0]] = i
	}
	sort.Sort(ByLength(intervals))

	ans := make(map[int]int)

	for k, v := range intervals {
		lo := 0
		hi := len(intervals) - 1
		mid := 0
		for lo < hi {
			mid = lo + (hi-lo)/2
			if intervals[mid][0] >= v[1] {
				hi = mid
			} else {
				lo = mid + 1
			}
		}
		if intervals[lo][0] >= v[1] && lo != k {
			ans[original[intervals[k][0]]] = original[intervals[lo][0]]
		} else {
			ans[original[intervals[k][0]]] = -1
		}
	}
	res := make([]int, 0)
	for i, _ := range intervals {
		res = append(res, ans[i])
	}

	return res

}
