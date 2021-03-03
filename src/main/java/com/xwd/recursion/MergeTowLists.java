package com.xwd.recursion;

import com.xwd.list.ListNode;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表
// 👍 1569 👎 0

/**
 * @program: algo
 * @description: 21
 * @author: xuwudong
 * @create: 2021-03-02 19:34
 **/
public class MergeTowLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode root = new ListNode();
        mergeTwoLists(l1, l2, root);
        return root.next;
    }

    private void mergeTwoLists(ListNode l1, ListNode l2, ListNode root) {
        if (l1 == null) {
            root.next = l2;
            return;
        } else if (l2 == null) {
            root.next = l1;
            return;
        }
        if (l1.val < l2.val) {
            root.next = l1;
            mergeTwoLists(l1.next, l2, root.next);
        } else {
            root.next = l2;
            mergeTwoLists(l1, l2.next, root.next);
        }
    }


    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode root;
        ListNode cur = new ListNode();
        root = cur;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            cur.next = l1;
            cur = l1;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur.next = l2;
            cur = l2;
            l2 = l2.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        MergeTowLists mergeTowList = new MergeTowLists();

    }
}
