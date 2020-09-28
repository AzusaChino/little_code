package sept

func less(nums []int, k int) int {
	var count = 0
	var product = 1
	for i,j := 0,0;j<len(nums);j++ {
		product *= nums[j]
		for j >= i && product >= k {
			product /= nums[i]
			i++
		}
		count += j-i+1
	}
	return count
}