package easy

import "fmt"

func Sqrt(x int) int {
	r := x
	for r*r > x {
		r = (r + x/r) / 2
	}
	return r
}

func main() {
	fmt.Println(Sqrt(8))
}
