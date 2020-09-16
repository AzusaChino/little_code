package bits

func isPowerOfFour(n int) bool {
	return (n&(n-1)) > 1 && (n&0x55555555) != 0
}
