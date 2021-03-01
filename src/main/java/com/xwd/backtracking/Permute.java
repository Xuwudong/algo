package com.xwd.backtracking;

import java.util.*;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        int n = nums.length;
        dfs(res, list, n, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int n, int first) {
        if (first == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = first; i < n; i++) {
            Collections.swap(list, i, first);
            dfs(res, list, n, first + 1);
            Collections.swap(list, i, first);
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        boolean[] used = new boolean[n];
        dfs(res, deque, n, 0, used, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> deque, int n, int first, boolean[] used, int[] nums) {
        if (first == n) {
            res.add(new ArrayList<>(deque));
            return;
        }
        // 注意i= 0
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                deque.addLast(nums[i]);
                used[i] = true;
                dfs(res, deque, n, first + 1, used, nums);
                deque.removeLast();
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        boolean[] used = new boolean[n];
        dfs(res, deque, n, 0, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> deque, int n, int first, int[] nums) {
        if (first == n) {
            res.add(new ArrayList<>(deque));
            return;
        }
        // i = first
        for (int i = first; i < n; i++) {
            deque.addLast(nums[i]);
            swap(nums, i, first);
            dfs(res, deque, n, first + 1, nums);
            swap(nums, i, first);
            deque.removeLast();
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> res = permute.permute3(new int[]{1, 2, 3});
        permute.print(res);
    }

    private void print(List<List<Integer>> res) {
        for (List<Integer> list : res) {
            System.out.print(list + "\t");
        }
    }

}
