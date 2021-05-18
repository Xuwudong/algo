package com.xwd.string;

import java.util.*;

//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//
// 说明：
//
//
// 字母异位词指字母相同，但排列不同的字符串。
// 不考虑答案输出的顺序。
//
//
// 示例 1:
//
//
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
//
//
// 示例 2:
//
//
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
//
// Related Topics 哈希表
// 👍 527 👎 0

/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-05-18 14:32
 **/
public class FindAnagrams {
    /**
     * 使用滑动窗口解决
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        int[] need = new int[26];
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i) - 'a']++;
        }
        int start = 0, end = 0;
        int[] window = new int[26];
        while (end < s.length()) {
            int index = s.charAt(end) - 'a';
            window[index]++;
            if (window[index] > need[index]) {
                if (need[index] == 0) {
                    Arrays.fill(window, 0);
                    start = end + 1;
                } else {
                    window[s.charAt(start) - 'a']--;
                    start++;
                }
            } else if (end - start + 1 == p.length()) {
                if (check(need, window)) {
                    res.add(start);
                }
                window[s.charAt(start) - 'a']--;
                start++;
            }
            end++;
        }
        return res;
    }

    private boolean check(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindAnagrams main = new FindAnagrams();
        System.out.println(main.findAnagrams("cbaebabacd", "abc"));
    }
}
