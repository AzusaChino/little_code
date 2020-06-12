package june

func sort(nums []int) {
	red, blue, green := 0, 0, 0
	for _, c := range nums {
		if c == 0 {
			red++
		} else if c == 1 {
			blue++
		} else if c == 2 {
			green++
		}
	}
	for i := 0; i < red; i++ {
		nums[i] = 0
	}
	for i := red; i < red+blue; i++ {
		nums[i] = 1
	}
	for i := red + blue; i < red+blue+green; i++ {
		nums[i] = 2
	}
}
