package com.xwd.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: algo
 * @description: 395
 * @author: xuwudong
 * @create: 2021-03-08 16:23
 **/
public class LongestSubString {
    public int longestSubString(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                // 如果字符c出现次数小于k,那c一定不在最长子串中
                int res = 0;
                for (String t : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubString(t, k));
                }
                return res;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        LongestSubString l = new LongestSubString();
        System.out.println(l.longestSubString("aaabb", 3));
        System.out.println(l.longestSubString("aacbbbdeeee", 2));
    }

}
