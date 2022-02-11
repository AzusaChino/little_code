package apr

func letterCombinations(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}
	var dict = map[rune]string{
		'2': "abc",
		'3': "def",
		'4': "ghi",
		'5': "jkl",
		'6': "mno",
		'7': "pqrs",
		'8': "tuv",
		'9': "wxyz",
	}
	var ans = []string{""}
	for _, c := range digits {
		var tmp []string
		for _, p := range ans {
			for _, q := range dict[c] {
				tmp = append(tmp, p+string(q))
			}
		}
		ans = tmp
	}
	return ans
}
