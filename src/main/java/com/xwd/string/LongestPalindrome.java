package com.xwd.string;

/**
 * 5.最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        char[] arr = s.toCharArray();
        // 记录回文起始位置
        int[] loc = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int low = i;
            int high = low;
            // 找出第一个与low不相同的元素：arr[high+1]
            while (high + 1 < arr.length && arr[high + 1] == arr[low]) {
                high++;
            }
            // 记录最后一个与low相同的元素
            i = high;
            while (high + 1 < arr.length && low - 1 >= 0 && arr[high + 1] == arr[low - 1]) {
                high++;
                low--;
            }
            if (high - low > loc[1] - loc[0]) {
                loc[1] = high;
                loc[0] = low;
            }
        }
        return s.substring(loc[0], loc[1] + 1);
    }
}
