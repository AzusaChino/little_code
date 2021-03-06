package sept

import "leetcode/common"

func insert(intervals [][]int, newInterval []int) [][]int {
	var ret [][]int
	index := 0
	for index < len(intervals) && intervals[index][1] < newInterval[0] {
		ret = append(ret, intervals[index])
	}
	for index < len(intervals) && intervals[index][0] <= newInterval[1] {
		newInterval = []int{
			common.Min(newInterval[0], intervals[index][0]),
			common.Max(newInterval[1], intervals[index][1]),
		}
		index += 1
	}
	ret = append(ret, newInterval)

	for index < len(intervals) {
		ret = append(ret, intervals[index])
	}
	return ret
}
