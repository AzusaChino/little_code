package aug

import "sort"

type CombinationIterator struct {
	combinations []string
}

func Constructor(characters string, combinationLength int) CombinationIterator {
	return CombinationIterator{helper(characters, combinationLength)}
}

func (that *CombinationIterator) Next() string {
	var res string
	res, that.combinations = that.combinations[0], that.combinations[1:]
	return res
}

func (that *CombinationIterator) HasNext() bool {
	return len(that.combinations) > 0
}

func helper(s string, length int) []string {
	var num uint32
	for _, c := range s {
		num |= 1 << int(c-'a')
	}

	var res []string
	for n := num; n > 0; n = (n - 1) & num {
		if checkLength(n, length) {
			res = append(res, transformToString(n))
		}
	}
	sort.Strings(res)
	return res
}

func checkLength(n uint32, length int) bool {
	for n > 0 {
		length -= int(n & 1)
		n >>= 1
	}
	return length == 0
}

func transformToString(n uint32) string {
	s := ""
	mask := uint32(1)
	for i := 0; i < 32; i++ {
		if n&(mask<<i) > 0 {
			s += string(byte(i) + 'a')
		}
	}
	return s
}
