package com.xwd.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class DFSSolution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        if (digits == "") return res;
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, digits, map, 0);
        return res;
    }

    public void dfs(List<String> res, StringBuilder sb, String digits, Map<Integer, String> map, int index) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String s = map.get(Integer.valueOf(digits.charAt(index)) - 48);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);
            dfs(res, sb, digits, map, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, 0, 0);
        return res;
    }

    private void dfs(List<String> res, String ans, int n, int c1, int c2) {
        if (ans.length() == n * 2) {
            res.add(ans);
            return;
        }
        if (c1 < n) {
            dfs(res, ans + "(", n, c1 + 1, c2);
        }
        if (c2 < c1) {
            dfs(res, ans + ")", n, c1, c2 + 1);
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode ret = pre;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            pre.next = next;
            cur.next = next.next;
            next.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return ret.next;
    }

    private void print(ListNode head){
        while(head != null){
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        DFSSolution s = new DFSSolution();
//        s.letterCombinations("23");
//        s.generateParenthesis(3);
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head = s.swapPairs(head);
        s.print(head);
    }
}