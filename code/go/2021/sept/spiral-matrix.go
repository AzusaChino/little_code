package sept

const (
	right = iota
	down
	left
	up
)

var dirs = []int{right, down, left, up}

func spiralOrder(matrix [][]int) (res []int) {
	m, n := len(matrix), len(matrix[0])
	res = make([]int, 0, m*n)

	l, r, t, b := 0, n-1, 0, m-1
	for cnt := 0; l <= r && t <= b; cnt++ {
		switch dirs[cnt%len(dirs)] {
		case right:
			for i, j := t, l; j <= r; j++ {
				res = append(res, matrix[i][j])
			}
			t++
		case down:
			for i, j := t, r; i <= b; i++ {
				res = append(res, matrix[i][j])
			}
			r--
		case left:
			for i, j := b, r; j >= l; j-- {
				res = append(res, matrix[i][j])
			}
			b--
		case up:
			for i, j := b, l; i >= t; i-- {
				res = append(res, matrix[i][j])
			}
			l++
		}
	}

	return
}
