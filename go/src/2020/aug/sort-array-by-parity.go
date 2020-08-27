package aug

func mySort(A []int) []int {

	for i, j := 0, 0; j < len(A); j++ {
		if A[j]&1 == 0 {
			tmp := A[i]
			i++
			A[i] = A[j]
			A[j] = tmp
		}
	}
	return A
}
