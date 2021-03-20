package com.xwd.backtracking.expamd;

import java.util.Arrays;

/**
 * 1079. 活字印刷
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 *
 * 注意：本题中，每个活字字模只能使用一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 *
 * 输入："AAABBC"
 * 输出：188
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
