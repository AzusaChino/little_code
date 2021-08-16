package aug

// NumArray define
type NumArray struct {
	prefixSum []int
}

// Constructor303 define
func Constructor303(nums []int) NumArray {
	for i := 1; i < len(nums); i++ {
		nums[i] += nums[i-1]
	}
	return NumArray{prefixSum: nums}
}

// SumRange define
func (this *NumArray) SumRange(i int, j int) int {
	if i > 0 {
		return this.prefixSum[j] - this.prefixSum[i-1]
	}
	return this.prefixSum[j]
}
