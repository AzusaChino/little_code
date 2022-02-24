package july

import "math/rand"

type Solution struct {
	Nums []int
}

func SolutionConstructor(nums []int) Solution {
	return Solution{
		Nums: nums,
	}
}

/** Resets the array to its original configuration and return it. */
func (this *Solution) Reset() []int {
	return this.Nums
}

/** Returns a random shuffling of the array. */
func (this *Solution) Shuffle() []int {
	if this.Nums == nil {
		return nil
	}
	cpy := make([]int, len(this.Nums))
	copy(cpy, this.Nums)
	for i := 1; i < len(cpy); i++ {
		j := rand.Intn(i + 1)
		cpy[i], cpy[j] = cpy[j], cpy[i]
	}
	return cpy
}
