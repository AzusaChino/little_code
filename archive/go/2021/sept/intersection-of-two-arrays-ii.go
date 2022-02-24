package sept

func intersect(nums1 []int, nums2 []int) []int {
	set := make(map[int]int)
	var res []int
	for _, i := range nums1 {
		set[i]++
	}
	for _, i := range nums2 {
		if v, ok := set[i]; ok {
			if v > 0 {
				res = append(res, i)
				set[i]--
			}
		}
	}
	return res
}
