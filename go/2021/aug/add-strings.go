package aug

func addStrings(num1 string, num2 string) string {
	maxLength := max(len(num1), len(num2))

	// allocate an extra byte for carry, we will remove it if carry is 0
	sum := make([]byte, maxLength+1)

	carry := byte(0)

	for i := 0; i < maxLength; i++ {
		a, b := byte(0), byte(0)

		if i < len(num1) {
			a = atoi(num1[len(num1)-i-1])
		}
		if i < len(num2) {
			b = atoi(num2[len(num2)-i-1])
		}

		s := a + b + carry
		carry = s / 10
		sum[len(sum)-i-1] = itoa(s % 10)
	}

	if carry > 0 {
		sum[0] = '1'
	} else {
		sum = sum[1:]
	}

	return string(sum)
}
