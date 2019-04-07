/***
 * 最小栈
 */
package com.xwd.list;

class Node {
	int val;
	int min;

	public Node(int val, int min) {
		this.val = val;
		this.min = min;
	}
}

/**
 * Consider each node in the stack having a minimum value.
 * 
 * @author admin
 *
 */
public class MinStack {
	private int n = 100; // 栈的大小
	private Node[] items = new Node[n];
	private int count; // 栈中元素个数

	public MinStack() {
	}

	public boolean push(int s) {
		if (count >= n) {
			return false;
		}
		int min = getMin();
		if (min < s) {
			items[count++] = new Node(s, min);
		} else {
			items[count++] = new Node(s, s);
		}
		return true;
	}

	public int pop() {
		if (count == 0) {
			return 0;
		}
		Node res = items[--count];
		items[count] = null;
		return res.val;
	}

	public int top() {
		if (count == 0) {
			return 0;
		}
		int pos = count - 1;
		return items[pos].val;
	}

	public int getMin() {
		if (count == 0) {
			return Integer.MAX_VALUE;
		}
		int pos = count - 1;
		return items[pos].min;
	}

}