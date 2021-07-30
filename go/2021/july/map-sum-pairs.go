package july

import "strings"

type MapSum struct {
	mp map[string]int
}

/** Initialize your data structure here. */
func MapSumConstructor() MapSum {
	return MapSum{
		mp: make(map[string]int),
	}
}

func (this *MapSum) Insert(key string, val int) {
	this.mp[key] = val
}

func (this *MapSum) Sum(prefix string) int {
	sum := 0
	for k, v := range this.mp {
		if strings.HasPrefix(k, prefix) {
			sum += v
		}
	}
	return sum
}
