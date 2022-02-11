package sept

func maxNumberOfBalloons(text string) int {
	var arr [26]int
	for _, v := range text {
		arr[v-'a']++
	}
	res := arr[1]
	res = min(res, arr[0])
	res = min(res, arr[11]/2)
	res = min(res, arr[14]/2)
	res = min(res, arr[13])

	return res
}
