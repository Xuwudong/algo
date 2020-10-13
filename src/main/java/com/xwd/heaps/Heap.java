package com.xwd.heaps;

import com.xwd.heaps.mergefiles.Node;

import java.io.File;
import java.util.Comparator;

/***
 * 数据结构 ：堆;数组第一个元素不存储数据 堆中的元素个数：count; count = arr.length-1
 * 
 * @author admin
 *
 */
public class Heap<T> {
	public T[] getArr() {
		return arr;
	}

	private T[] arr;
	private int count;
	private Comparator<T> comparator;

	public int getCount() {
		return count;
	}

	@SuppressWarnings("unchecked")
	public Heap(int size, Comparator<T> comparator) {
		this.arr = (T[]) new Object[size];
		this.count = 0;
		this.comparator = comparator;
	}

	/**
	 * 堆排
	 * 
	 * @param arr
	 */
	public void heapSort() {
		buildHeap(arr, arr.length - 1);
		for (int i = arr.length - 1; i > 1; i--) {
			swap(arr, 1, i);
			heapify(arr, i - 1, 1);
		}
	}

	/**
	 * 建堆
	 * 
	 * @param arr
	 * @param n
	 */
	public void buildHeap(T[] arr, int n) {
		for (int i = n / 2; i > 0; i--) {
			heapify(arr, n, i);
		}
	}

	/**
	 * 堆化（从上往下）
	 * 
	 * @param arr
	 * @param n
	 * @param i
	 */
	public void heapify(T[] arr, int n, int i) {
		while (true) {
			int maxPos = i;
			if (i * 2 <= n && this.comparator.compare(arr[i], arr[i * 2]) < 0) {
				maxPos = i * 2;
			}
			if (i * 2 + 1 <= n && this.comparator.compare(arr[maxPos], arr[i * 2 + 1]) < 0) {
				maxPos = i * 2 + 1;
			}
			if (maxPos == i) {
				break;
			}
			swap(arr, i, maxPos);
			i = maxPos;
		}
	}

	/**
	 * 插入
	 * 
	 * @param value
	 */
	public void insert(T value) {
		if (count == 0) {
			arr[++count] = value;
			return;
		}
		if (count >= arr.length) {
			throw new Error("arrayIndexOutOfRange");
		}
		int n = ++count;
		arr[n] = value;
		while (n / 2 > 0 && this.comparator.compare(arr[n / 2], arr[n]) < 0) {
			swap(arr, n / 2, n);
			n = n / 2;
		}
	}

	/**
	 * 删除堆顶元素
	 * 
	 * @return
	 */
	public T deleteFirst() {
		if (count == 0) {
			throw new Error("array is empty");
		}
		T ret = arr[1];
		arr[1] = arr[count];
		arr[count] = null;
		count--;
		heapify(arr, count, 1);
		return ret;
	}

	public void swap(T[] arr, int n, int m) {
		T tmp = arr[n];
		arr[n] = arr[m];
		arr[m] = tmp;
	}

	public static void main(String[] args) {
		Heap<Node> heap = new Heap<>(15, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (Long.parseLong(o1.getWord()) > Long.parseLong(o2.getWord())) {
					return 1;
				} else if (Long.parseLong(o1.getWord()) < Long.parseLong(o2.getWord())) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		for (int i = 0; i < 10; i++) {
			Node node = new Node(i + "", new File(""));
			heap.insert(node);
		}
		heap.print();
//
//		for (int i = 0; i < 10; i++) {
//			heap.deleteFirst();
//			heap.print();
//		}
//		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//		heapSort(arr);
//		for (int i : arr) {
//			System.out.print(i);
//		}
//		System.out.println();
	}

	public void print() {
		for (Object i : arr) {
			System.out.print(i + "  ");
		}
		System.out.println(count);
	}
}
