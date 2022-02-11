package apr

func rotate(matrix [][]int) {
	row := len(matrix)
	if row <= 0 {
		return
	}
	col := len(matrix[0])

	for i := 0; i < row; i++ {
		for j := i + 1; j < col; j++ {
			matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
		}
	}
	// rotate by vertical centerline 竖直轴对称翻转
	halfColumn := col / 2
	for i := 0; i < row; i++ {
		for j := 0; j < halfColumn; j++ {
			matrix[i][j], matrix[i][col-j-1] = matrix[i][col-j-1], matrix[i][j]

		}
	}
}
