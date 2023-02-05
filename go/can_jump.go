package main

func canJump(nums []int) bool {
	l := len(nums)
	arriveMap := map[int]bool{0: true}
	for i := 0; i < l; i++ {
		jumpTo := nums[i] + i
		for j := i + 1; j <= jumpTo; j++ {
			if !arriveMap[j] {
				arriveMap[j] = true
			}
		}
	}
	return arriveMap[l-1]
}
