package aug

func minPatches(nums []int, n int) int {
	cnt, patch, tot, i := 0, 0, len(nums), 0
	for patch < n {
		if i < tot && patch+1 >= nums[i] {
			patch += nums[i]
			i++
		} else {
			cnt++
			patch += patch + 1
		}
	}
	return cnt
}
