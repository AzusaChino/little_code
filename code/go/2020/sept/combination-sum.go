package sept

import "sort"

func CombinationSum(candidates []int, target int) [][]int {
	var result [][]int
	sort.Ints(candidates)
	var path []int
	traverseFunc(&result, path, candidates, 0, 0, target)
	return result
}

func traverseFunc(result *[][]int, path, candidates []int, position, sum, target int) int {
	if sum == target {
		// fmt.Println(path)
		temp := make([]int, len(path))
		copy(temp, path)
		*result = append(*result, temp)
		return 0
	}
	if sum > target {
		return -1
	}
	for i := position; i < len(candidates); i++ {
		sum += candidates[i]
		path = append(path, candidates[i])
		flag := traverseFunc(result, path, candidates, i, sum, target)
		sum -= candidates[i]
		path = path[:len(path)-1]
		if flag == -1 {
			return 0
		}
	}
	return 0
}

func combinationSum4(nums []int, target int) int {
	var temp []int
	return _backtrack(nums, temp, target, 0)

}

func _backtrack(nums []int, temp []int, target int, index int) int {
	if target == 0 {

	}
	return 0
}
