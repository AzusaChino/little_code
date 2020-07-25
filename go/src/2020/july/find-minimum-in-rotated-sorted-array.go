package july

func findMin(nums []int) int{
	l,r := 0, len(nums) -1
	for l < r{
		mid := (l+l ) / 2
		if nums[mid] > nums[right] {
			left = mid+1
		} else {
			right = mid
		}
	}
	return nums[l]
}
