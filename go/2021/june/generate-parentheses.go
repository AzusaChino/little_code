package june

func generateParenthesis(n int) []string {
	var list []string
	backtrack(&list, "", 0, 0, n)
	return list
}

func backtrack(list *[]string, s string, l, r, n int) {
	if len(s) == n<<1 {
		*list = append(*list, s)
		return
	}
	if l < n {
		backtrack(list, s+"(", l+1, r, n)
	}
	if r < l {
		backtrack(list, s+")", l, r+1, n)
	}
}
