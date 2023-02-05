package main

var y = 0

func reverse(x int) int {
	if x < 0 {
		r(-x)
		return -y
	} else {
		r(x)
		return y
	}
}

func r(x int) int {
	if x == 0 {
		return 0
	}
	y = x%10 + y*10
	return r(x / 10)
}
