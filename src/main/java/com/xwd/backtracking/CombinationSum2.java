package com.xwd.backtracking;

import com.xwd.util.ListUtil;

import java.util.*;

/**
 *40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>(candidates.length);
        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);
        dfs(res, deque, candidates, target, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> path, int[] arr, int left, int index) {
        if (left == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            // 大剪枝。有遇到大于left也回溯
            if (arr[i] > left) {
                break;
            }
            // 小剪枝，去除重复组合
            if (i > index && arr[i - 1] == arr[i]) {
                continue;
            }
            path.addLast(arr[i]);
            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(res, path, arr, left - arr[i], i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum2 c = new CombinationSum2();
        List<List<Integer>> res = c.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        ListUtil.print(res);
    }
}
