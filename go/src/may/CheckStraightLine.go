package may

func CheckStraightLine(coordinates [][]int) bool {
	if len(coordinates) == 2 {
		return true
	}
	x0, y0 := coordinates[0][0], coordinates[0][1]
	x1, y1 := coordinates[1][0], coordinates[1][1]

	dx, dy := x1-x0, y1-y0

	for _, co := range coordinates {
		x, y := co[0], co[1]
		if dx*(y-y1) != dy*(x-x1) {
			return false
		}
	}
	return true

}
