package com.xwd.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum3 {
    private int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(res, deque, k, n, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> deque, int k, int left, int index) {
        if (left == 0 && deque.size() == k) {
            res.add(new ArrayList<>(deque));
            return;
        }
        if (deque.size() >= k) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (arr[i] > left) {
                break;
            }
            if (i > index && arr[i - 1] == arr[i]) {
                continue;
            }
            deque.addLast(arr[i]);
            dfs(res, deque, k, left - arr[i], i + 1);
            deque.removeLast();
        }
    }
}
