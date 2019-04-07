package com.xwd.list;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ListPracTest {
	@Test
	public void testCreate() {
		int[] arr = { 1, 2, 3, 4, 5 };
		ListNode head = ListPrac.create(arr);
		assertEquals(head.val, 1);
		assertEquals(head.next.val, 2);
	}

	@Test
	public void testTraverse() {
		int[] arr = { 1, 2, 3, 4, 5 };
		ListNode head = ListPrac.create(arr);
		ListPrac.traverse(head);
	}

	@Test
	public void testMergeTwoLists() {
		int[] arr1 = { 1, 2, 4 };
		int[] arr2 = { 1, 3, 4, 5 };
		ListNode head1 = ListPrac.create(arr1);
		ListNode head2 = ListPrac.create(arr2);
		ListNode head = ListPrac.mergeTwoLists(head1, head2);
		assertEquals(head.val, 1);
		assertEquals(head.next.val, 1);
	}

	@Test
	public void testRemoveNthFromEnd() {
		int[] arr = { 1, 2, 3, 4, 5 };
		ListNode head = ListPrac.create(arr);
		head = ListPrac.removeNthFromEnd(head, 2);
		assertEquals(head.next.next.next.val, 5);
		ListPrac.traverse(head);
	}
}
