package may

func ambiguousCoordinates(S string) []string {
	ambiguous := []string{}
	numbers := []byte(S[1 : len(S)-1])
	for i := 1; i < len(numbers); i++ {
		coordinateXs, coordinateYs := construct(numbers[:i]), construct(numbers[i:])
		for _, x := range coordinateXs {
			for _, y := range coordinateYs {
				ambiguous = append(ambiguous, "("+string(x)+", "+string(y)+")")
			}
		}
	}
	return ambiguous
}

func construct(data []byte) [][]byte {
	if len(data) == 1 {
		return [][]byte{data}
	}
	if data[0] == '0' && data[len(data)-1] == '0' {
		return nil
	}
	if data[len(data)-1] == '0' {
		return [][]byte{data}
	}
	if data[0] == '0' {
		return [][]byte{insertPoint(data, 1)}
	}
	result := [][]byte{data}
	for i := 1; i < len(data); i++ {
		result = append(result, insertPoint(data, i))
	}
	return result
}

func insertPoint(data []byte, index int) []byte {
	result := make([]byte, len(data)+1)
	copy(result, data[:index])
	result[index] = '.'
	copy(result[index+1:], data[index:])
	return result
}
