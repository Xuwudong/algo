package com.xwd.leekCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for singly-linked list.
 *
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode pre = new ListNode(0);
		int carry = 0;
		ListNode cur = pre;
		while (l1 != null || l2 != null) {
			int x = l1 != null ? l1.val : 0;
			int y = l2 != null ? l2.val : 0;
			int sum = x + y + carry;
			carry = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			l1 = l1 != null ? l1.next : l1;
			l2 = l2 != null ? l2.next : l2;
		}
		if (carry != 0) {
			cur.next = new ListNode(carry);
		}
		return pre.next;
	}

	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		char[] chars = s.toCharArray();
		Queue<Character> queue = new LinkedList<>();
		for (char c : chars) {
			if (queue.size() > 0 && queue.contains(c)) {
				while (c != queue.poll()) {

				}
			}
			queue.add(c);
			max = Math.max(max, queue.size());
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new Solution2().lengthOfLongestSubstring("jbpnbwwd"));
//		ListNode l1 = new ListNode(9);
//		ListNode l4 = new ListNode(8);
////		ListNode l3 = new ListNode(3);
//		l1.next = l4;
////		l4.next = l3;
//		ListNode l2 = new ListNode(1);
////		ListNode l6 = new ListNode(6);
////		ListNode l7 = new ListNode(4);
////		l2.next = l6;
////		l6.next = l7;
//		ListNode list = new Solution2().addTwoNumbers(l1, l2);
//		while (list != null) {
//			System.out.println(list.val);
//			list = list.next;
//		}
	}
}