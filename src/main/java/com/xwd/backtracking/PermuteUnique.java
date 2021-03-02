package com.xwd.backtracking;

import com.xwd.util.ListUtil;

import java.util.*;

/**
 * @program: algo
 * @description:
 * @author: xuwudong@bigo.sg
 * @create: 2021-03-02 11:35
 **/
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(list, deque, nums, 0, used);
        return list;
    }

    private void dfs(List<List<Integer>> list, Deque<Integer> deque, int[] nums, int first, boolean[] used) {
        if (first == nums.length) {
            list.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            deque.addLast(nums[i]);
            used[i] = true;
            dfs(list, deque, nums, first + 1, used);
            used[i] = false;
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        List<List<Integer>> list = permuteUnique.permuteUnique(new int[]{1, 1, 2});
        ListUtil.print(list);
    }
}
