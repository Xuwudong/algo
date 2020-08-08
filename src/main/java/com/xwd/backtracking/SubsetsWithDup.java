package com.xwd.backtracking;

import java.util.*;

/**
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(res, deque, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> deque, int[] nums, int index) {
        res.add(new ArrayList<Integer>(deque));
        for (int i = index; i < nums.length; i++) {
            if (i - 1 >= index && nums[i] == nums[i - 1]) {
                continue;
            }
            deque.addLast(nums[i]);
            dfs(res, deque, nums, i + 1);
            deque.removeLast();
        }
    }
}
