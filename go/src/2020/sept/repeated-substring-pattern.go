package sept

type String string

func hasPattern(s String) bool {
	if len(s) <= 1 {
		return false
	}
	le := len(s)
	for i := le / 2; i >= 1; i-- {
		if le%i == 0 {
			size := le / i
			sub := s[0:i]
			var j int
			for j = 1; j < size; j++ {
				if !sub.equals(s[j*i : (j+1)*i]) {
					break
				}
			}
			if size == j {
				return true
			}
		}
	}
	return false
}

func (s String) equals(other String) bool {
	le := len(other)
	for i := 0; i < le; i++ {
		if s[i] != other[i] {
			return false
		}

	}
	return true
}
