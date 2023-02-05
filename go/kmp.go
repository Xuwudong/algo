package main

func Next(needle string) []int {
	next := make([]int, len(needle)+1)
	i := 0
	j := -1
	next[0] = -1
	//next[1] = 0
	for i < len(needle) {
		if j == -1 || needle[i] == needle[j] {
			i++
			j++
			next[i] = j
		} else {
			j = next[j]
		}
	}
	return next
}
func strStr(haystack string, needle string) int {
	next := Next(needle)
	i := 0
	j := 0
	for i < len(haystack) && j < len(needle) {
		if j == -1 || haystack[i] == needle[j] {
			i++
			j++
		} else {
			j = next[j]
		}
	}
	if j == len(needle) {
		return i - j
	}
	return -1
}
