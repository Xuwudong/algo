package com.xwd.backtracking;

import java.util.Arrays;

/**
 * @program: algo
 * @description: 1079
 * @author: xuwudong
 * @create: 2021-03-15 16:33
 **/
public class NumTilePossibilities {
    private int count = 0;

    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        boolean[] used = new boolean[arr.length];
        dfs(arr, used, 0);
        return count;
    }

    private void dfs(char[] arr, boolean[] used, int index) {
        if (index != 0) {
            count++;
        }
        if (index == arr.length) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i] || (i > 0 && arr[i] == arr[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            dfs(arr, used, index + 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new NumTilePossibilities().numTilePossibilities("AAB"));
        System.out.println(new NumTilePossibilities().numTilePossibilities("AAABBC"));
    }
}
