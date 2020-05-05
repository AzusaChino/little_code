package may

func CanConstruct(ransomNote string, magazine string) bool {
	find := 0
	for _, c1 := range ransomNote {
		count := 0
		for _, c2 := range magazine {
			if c2 == c1 {
				c2 = '0'
				find++
				break
			} else {
				if count == len(magazine) {
					return false
				}
				count++
			}
		}
	}
	return find == len(ransomNote)
}
