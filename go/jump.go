package main

func jump(nums []int) int {
	n := len(nums)
	dpMap := map[int]int{0: 0}
	doneMap := map[int]bool{}
	for i := 1; i < len(nums); i++ {
		dpMap[i] = n - 1
	}
	for i := 1; i <= n-1; i++ {
		if !doneMap[i] {
			for j := i + 1; j <= nums[i]+i; j++ {
				if dpMap[i]+1 < dpMap[j] {
					dpMap[j] = dpMap[i] + 1
					doneMap[j] = true
				}
			}
		}
	}
	return dpMap[n-1]
}

func dp(nums []int, n int) map[int]int {
	if n == 0 {
		return map[int]int{0: 0}
	}

	lastMap := dp(nums, n-1)
	curMin := n
	for i := 0; i < n; i++ {
		if nums[i]+lastMap[i] >= n {
			if lastMap[i]+1 < curMin {
				curMin = lastMap[i] + 1
			}
		}
	}
	lastMap[n] = curMin
	return lastMap
}
