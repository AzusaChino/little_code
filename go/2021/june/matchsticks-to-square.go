package june

import "sort"

func makesquare(matchsticks []int) bool {
	if len(matchsticks) < 4 {
		return false
	}
	sum := 0
	for i := range matchsticks {
		sum += i
	}
	if sum%4 != 0 {
		return false
	}
	sort.Sort(sort.Reverse(sort.IntSlice(matchsticks)))
	sli := make([]int, 4)

	return dfs(sli, matchsticks, 0, sum/4)
}

func dfs(sli []int, nums []int, index int, sum int) bool {
	if index == len(nums) {
		return sli[0] == sli[1] && sli[1] == sli[2] && sli[2] == sli[3]
	}
	for i := 0; i < 4; i++ {
		if (sli[i] + nums[index]) > sum {
			continue
		}
		j := i
		for j > 0 {
			j--
			if sli[i] == sli[j] {
				break
			}
		}
		if j != -1 {
			continue
		}
		sli[i] += nums[index]
		if dfs(sli, nums, index+1, sum) {
			return true
		}
		sli[i] -= nums[index]
	}
	return false
}
