package aug

func fizzBuzz(n int) []string {
	res := make([]string, n)
	// 全部写成i
	for i := 1; i <= n; i++ {
		res[i-1] = string(rune(i))
	}
	// 把3*x都换成Fizz
	for i := 2; i < n; i += 3 {
		res[i] = "Fizz"
	}

	// 把5*x都换成Buzz
	for i := 4; i < n; i += 5 {
		res[i] = "Buzz"
	}
	// 把15*x都换成FB
	for i := 14; i < n; i += 15 {
		res[i] = "FizzBuzz"
	}
	return res
}
