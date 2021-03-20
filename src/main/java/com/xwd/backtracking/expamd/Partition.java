package com.xwd.backtracking.expamd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
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
