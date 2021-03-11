package com.xwd.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algo
 * @description: 131
 * @author: xuwudong
 * @create: 2021-03-11 16:12
 **/
public class Partition {
    boolean[][] f;
    List<List<String>> res = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        // 全部置为true
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }

        // 动态规划，计算每个长度是否是回文串，注意i, j的值
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
            }
        }
        dfs(s, 0);
        return res;
    }

    /**
     *
     * @param s
     * @param index 表示索引
     */
    private void dfs(String s, int index) {
        if (index == n) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int j = index; j < n; j++) {
            if (f[index][j]) {
                ans.add(s.substring(index, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Partition().partition("aab"));
        System.out.println(new Partition().partition("bb"));
    }

}
