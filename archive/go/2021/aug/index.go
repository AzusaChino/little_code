package aug

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

// atoi is usually used in strongly typed languages and opens as ASCII to Integer
// because in ASCII characters are represented by number in the ASCII table we can convert
// the digit character into it's number by substracting the number of the first digit in the table '0'
func atoi(a byte) byte {
	return a - '0'
}

// Integer to ASCII
// We're performing the reverse of atoi by adding the char code of '0'
func itoa(a byte) byte {
	return '0' + a
}
