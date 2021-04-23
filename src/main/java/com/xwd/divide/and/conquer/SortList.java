package com.xwd.divide.and.conquer;

import com.xwd.list.ListNode;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 进阶：
//
//
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
//
//
//
//
// 示例 1：
//
//
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
//
//
// 示例 2：
//
//
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
//
//
// 示例 3：
//
//
//输入：head = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 5 * 104] 内
// -105 <= Node.val <= 105
//
// Related Topics 排序 链表
// 👍 1101 👎 0


/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-04-21 12:17
 **/
public class SortList {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode pre = sortList(head, mid);
        ListNode post = sortList(mid, tail);
        return merge(pre, post);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode pre = new ListNode();
        ListNode cur = pre;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
                cur = cur.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
                cur = cur.next;
            }
        }
        if(head1 != null) {
            cur.next = head1;
        }
        if(head2 != null) {
            cur.next = head2;
        }
        return pre.next;
    }
}
