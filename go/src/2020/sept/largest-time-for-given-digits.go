package sept

import "strconv"

func largestTimeFromDigits(A []int) string {
	var maxTime string
	// function define
	var dfs func(start int)

	// function to make times as string.
	var toString = func(times []int) string {
		return strconv.Itoa(times[0]) + strconv.Itoa(times[1]) + ":" + strconv.Itoa(times[2]) + strconv.Itoa(times[3])
	}

	// function to check times valid or not.
	var checkValid = func(times []int) bool {
		hours, minutes := times[0]*10+times[1], times[2]*10+times[3]

		if hours >= 24 || minutes >= 60 {
			return false
		}
		return true
	}

	dfs = func(start int) {
		if start == len(A)-1 {
			if checkValid(A) {
				time := toString(A)
				if maxTime < time {
					maxTime = time
				}
			}
			return
		}

		for i := start; i < len(A); i++ {
			A[i], A[start] = A[start], A[i]
			dfs(start + 1)
			A[i], A[start] = A[start], A[i]
		}
	}

	dfs(0)

	return maxTime
}
