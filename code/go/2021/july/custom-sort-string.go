package july

import "strings"

func customSortString(order string, str string) string {
	dict := make(map[rune]int)
	for _, s := range str {
		if v, ok := dict[s]; ok {
			dict[s] = v + 1
		} else {
			dict[s] = 1
		}
	}
	var result string = ""
	for _, s := range order {
		if v, ok := dict[s]; ok {
			result += strings.Repeat(string(s), v)
		}
	}
	for k, v := range dict {
		if !strings.ContainsRune(order, k) {
			result += strings.Repeat(string(k), v)
		}
	}
	return result
}
