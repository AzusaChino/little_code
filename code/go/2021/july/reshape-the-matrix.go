package july

func matrixReshape(nums [][]int, r int, c int) [][]int {
	if canReshape(nums, r, c) {
		return reshape(nums, r, c)
	}
	return nums
}

func canReshape(nums [][]int, r, c int) bool {
	row := len(nums)
	column := len(nums[0])
	return row*column == r*c
}

func reshape(nums [][]int, r, c int) [][]int {
	newShape := make([][]int, r)
	for index := range newShape {
		newShape[index] = make([]int, c)
	}
	rowIndex, colIndex := 0, 0
	for _, row := range nums {
		for _, col := range row {
			if colIndex == c {
				colIndex = 0
				rowIndex++
			}
			newShape[rowIndex][colIndex] = col
			colIndex++
		}
	}
	return newShape
}
