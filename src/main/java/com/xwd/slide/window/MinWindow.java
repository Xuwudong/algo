package com.xwd.slide.window;

import java.util.HashMap;
import java.util.Map;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//
// 示例 1：
//
//
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//
//
// 示例 2：
//
//
//输入：s = "a", t = "a"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 105
// s 和 t 由英文字母组成
//
//
//
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 1102 👎 0


/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-04-13 16:42
 **/
public class MinWindow {

    public String minWindow(String s, String t) {
        Map<Character, Integer> required = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        // cnt 记录字符的种类
        int cnt = 0;
        int start = 0, end = s.length() + 1;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (required.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).intValue() == required.get(c).intValue()) {
                    // 该类型的字符已经收集完成
                    cnt++;
                }
            }

            while (cnt == required.size()) {
                if (right - left < end - start) {
                    start = left;
                    end = right;
                }
                char removeC = s.charAt(left);
                if (!required.containsKey(removeC)) {

                } else if (window.get(removeC) > required.get(removeC)) {
                    window.put(removeC, window.get(removeC) - 1);
                } else {
                    window.put(removeC, window.get(removeC) - 1);
                    cnt--;
                }
                left++;
            }

            while (left <= right && !required.containsKey(s.charAt(left))) {
                left++;
            }
            right++;
        }
        return end == s.length() + 1 ? "" : s.substring(start, end + 1);
    }

}
