package com.xwd.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics
// 👍 1159 👎 0

/**
 * @program: algo
 * @description:
 * @author: xuwudong@bigo.sg
 * @create: 2021-03-01 15:44
 **/
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>(nums.length);
        boolean[] used = new boolean[nums.length];
        dfs(list, deque, nums, 0, used);
        return list;
    }

    private void dfs(List<List<Integer>> list, Deque<Integer> deque, int[] nums, int index, boolean[] used) {
        if (index == nums.length) {
            list.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            deque.addLast(nums[i]);
            used[i] = true;
            dfs(list, deque, nums, index + 1, used);
            used[i] = false;
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        Permute p = new Permute();
        List<List<Integer>> list = p.permute(new int[]{1, 2, 3});
        print(list);
    }

    public static void print(List<List<Integer>> list) {
        for (List<Integer> list1 : list) {
            System.out.print(list1 + "\t");
        }
    }
}
