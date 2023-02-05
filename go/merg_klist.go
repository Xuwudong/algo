package main

import "container/heap"

type ListNode struct {
	Val  int
	Next *ListNode
}

type IntHeap []int

func (h IntHeap) Len() int { return len(h) }

func (h IntHeap) Swap(i, j int) { h[i], h[j] = h[j], h[i] }

func (h IntHeap) Less(i, j int) bool { return h[i] < h[j] }

func (h *IntHeap) Push(x interface{}) {
	*h = append(*h, x.(int))
}

func (h *IntHeap) Pop() interface{} {
	n := len(*h)
	x := (*h)[n-1]
	*h = (*h)[:n-1]
	return x
}

func mergeKLists(lists []*ListNode) *ListNode {
	intHeap := make(IntHeap, 0)
	heap.Init(&intHeap)
	for _, list := range lists {
		for list != nil {
			heap.Push(&intHeap, list.Val)
			list = list.Next
		}
	}
	var result, head *ListNode
	result = new(ListNode)
	result.Next = nil
	head = result
	for intHeap.Len() > 0 {
		value := heap.Pop(&intHeap).(int)
		p := new(ListNode)
		p.Val = value
		p.Next = nil
		result.Next = p
		result = result.Next
	}
	return head.Next
}
