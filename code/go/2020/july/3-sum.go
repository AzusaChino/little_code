package july

import "sort"

func threeSum(nums []int) [][]int {
	var results [][]int
	sort.Ints(nums)
	for i := 0; i < len(nums)-2; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue //To prevent the repeat
		}
		target, left, right := -nums[i], i+1, len(nums)-1
		for left < right {
			sum := nums[left] + nums[right]
			if sum == target {
				results = append(results, []int{nums[i], nums[left], nums[right]})
				left++
				right--
				for left < right && nums[left] == nums[left-1] {
					left++
				}
				for left < right && nums[right] == nums[right+1] {
					right--
				}
			} else if sum > target {
				right--
			} else if sum < target {
				left++
			}
		}
	}
	return results
}

func three_sum(nums []int) [][]int {
	var result [][]int
	sort.Ints(nums)
	var length = len(nums)
	for i := 0; i < length-2; i++ {
		if i > 1 && nums[i] == nums[i-1] {
			continue
		}
		for j := i + 1; j < length-1; j++ {
			if nums[j] == nums[j-1] {
				continue
			}
			for k := j + 1; k < length; k++ {
				if nums[k] == nums[k-1] {
					continue
				}
				if nums[i]+nums[j]+nums[k] == 0 {
					result = append(result, []int{nums[i], nums[j], nums[k]})
				}
			}
		}
	}
	return result
}
