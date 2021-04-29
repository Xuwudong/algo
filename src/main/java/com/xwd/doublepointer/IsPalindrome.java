package com.xwd.doublepointer;

import com.xwd.list.ListNode;

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-04-28 10:27
 **/
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = null;
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        boolean result = true;
        while (result && pre != null) {
            if (pre.val != head.val) {
                result = false;
            }
            pre = pre.next;
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(2);
//        ListNode _4 = new ListNode(3);
        ListNode _5 = new ListNode(1);
        head.next = _2;
        _2.next = _3;
        _3.next = _5;
//        _4.next = _5;
        System.out.println(new IsPalindrome().isPalindrome(head));
    }
}
