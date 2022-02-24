package sept

import (
	"math"
	"strconv"
	"strings"
)

func compareVersion(version1 string, version2 string) int {
	v1, v2 := strings.Split(version1, "\\."), strings.Split(version2, "\\.")
	max := int(math.Max(float64(len(v1)), float64(len(v2))))

	for i := 0; i < max; i++ {
		var x, y int
		if i < len(v1) {
			x, _ = strconv.Atoi(v1[i])
		} else {
			x = 0
		}
		if i < len(v2) {
			y, _ = strconv.Atoi(v2[i])
		} else {
			y = 0
		}
		if (x - y) > 0 {

		} else if (x - y) < 0 {

		}
	}
	return 0
}
