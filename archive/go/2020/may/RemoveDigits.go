package may

import "strings"

func removeKdigits(num string, k int) string {
	if k == 0 {
		return num
	}
	if k >= len(num) {
		return "0"
	}
	for ; k > 0; k-- {
		length := len(num)
		i := 0
		for i+1 < length && num[i] <= num[i+1] {
			i += 1
		}
		num = num[:i] + num[i+1:]
	}

	// remove leading 0s
	length := len(num)
	for {
		// TrimPrefix only remove one 0
		num = strings.TrimPrefix(num, "0")
		if length == len(num) {
			break
		}
		length = len(num)
	}
	if len(num) == 0 {
		return "0"
	}
	return num
}
