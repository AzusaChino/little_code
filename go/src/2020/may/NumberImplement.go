package may

func FindComplement(num int) int {
	x := 1
	for num > x {
		x = x*2 + 1
	}
	return x - num
}
