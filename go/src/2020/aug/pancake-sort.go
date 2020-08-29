package aug

func pancakeSort(A []int) []int {
	var res []int
	var i int
	for x := len(A); x > 0; x-- {
		for i = 0; A[i] != x; i++ {
		}
		MyReverse(A, i+1)
		res = append(res, i+1)
		MyReverse(A, x)
		res = append(res, x)
	}
	return res
}

func MyReverse(nums []int, k int) {
	for i, j := 0, k-1; i < j; i++ {
		nums[i], nums[j] = nums[j], nums[i]
	}
}
