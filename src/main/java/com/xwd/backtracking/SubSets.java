package com.xwd.backtracking;

import java.util.*;

/**
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(res, deque, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> deque, int[] nums, int index) {
        res.add(new ArrayList<Integer>(deque));
        for (int i = index; i < nums.length; i++) {
            deque.addLast(nums[i]);
            dfs(res, deque, nums, i + 1);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        subSets.subsets(new int[]{1, 2, 3});
    }
}
