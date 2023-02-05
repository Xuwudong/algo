package main

var res = make([]string, 0)

func generateParenthesis(n int) []string {
	dfs("", n, 0, 0)
	return res
}

func dfs(s string, n int, c int, c2 int) {
	if len(s) == n*2 {
		res = append(res, s)
		s = ""
		return
	}

	if c < n {
		s += "("
		c++
		dfs(s, n, c, c2)
		s = s[0 : len(s)-1]
		c--
	}
	if c2 < n && c2 < c {
		s += ")"
		c2++
		dfs(s, n, c, c2)
		s = s[0 : len(s)-1]
		c2--
	}

}
