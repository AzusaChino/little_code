package dp

func MaxCoins(nums []int) int {
	n := len(nums)
	points := make([]int, n+2)
	points[0], points[n+1] = 1, 1
	for i := 1; i <= n; i++ {
		points[i] = nums[i-1]
	}

	dp := make([][]int, n+2)
	for d := range dp {
		d = make([]int, n+2)
	}

	for i := n; i >= 0; i-- {
		for j := i + 1; j < n+2; j++ {
			for k := i + 1; k < j; k++ {

			}
		}
	}

}
