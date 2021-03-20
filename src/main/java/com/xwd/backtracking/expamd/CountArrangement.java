package com.xwd.backtracking.expamd;

import java.util.List;

/**
 * 526. 优美的排列
 * 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
 *
 * 第 i 位的数字能被 i 整除
 * i 能被第 i 位上的数字整除
 * 现在给定一个整数 N，请问可以构造多少个优美的排列？
 *
 * 示例1:
 *
 * 输入: 2
 * 输出: 2
 * 解释:
 *
 * 第 1 个优美的排列是 [1, 2]:
 *   第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
 *   第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
 *
 * 第 2 个优美的排列是 [2, 1]:
 *   第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
 *   第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
 * @program: algo
 * @description: 526 优美的排列
 * @author: xuwudong
 * @create: 2021-03-15 12:21
 **/
public class CountArrangement {

    private int count = 0;

    public int countArrangement(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        dfs(arr, 0);
        return count;
    }

    private void dfs(int[] arr, int index) {
        if (index == arr.length) {
            count++;
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (arr[i] % (index + 1) == 0 || (index + 1) % arr[i] == 0) {
                swap(arr, i, index);
                dfs(arr, index + 1);
                swap(arr, i, index);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void dfs(int[] arr, boolean[] used, List<Integer> list, int index) {
        if (index == arr.length) {
            count++;
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                if (arr[i] % (list.size() + 1) == 0 || (list.size() + 1) % arr[i] == 0) {
                    list.add(arr[i]);
                    used[i] = true;
                    dfs(arr, used, list, index + 1);
                    used[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountArrangement().countArrangement(2));
        System.out.println(new CountArrangement().countArrangement(3));
    }

}
