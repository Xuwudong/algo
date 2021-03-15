package com.xwd.backtracking;

import java.util.List;

/**
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
