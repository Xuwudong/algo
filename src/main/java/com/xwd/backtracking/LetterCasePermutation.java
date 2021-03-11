package com.xwd.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * <p>
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 * <p>
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 */
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> res = new ArrayList<>();
        res.add(new StringBuilder());
        for (char c : S.toCharArray()) {
            int n = res.size();
            if (c >= 48 && c <= 57) {
                for (StringBuilder sb : res) {
                    sb.append(c);
                }
            } else {
                for (int i = 0; i < n; i++) {
                    res.add(new StringBuilder(res.get(i)));
                    res.get(i).append(Character.toLowerCase(c));
                    res.get(i + n).append(Character.toUpperCase(c));
                }
            }
        }
        List<String> list = new ArrayList();
        for (StringBuilder s : res) {
            list.add(s.toString());
        }
        return list;
    }

    public List<String> letterCasePermutation2(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, s, sb, 0);
        return res;
    }


    private void dfs(List<String> res, String s, StringBuilder sb, int index) {
        if (sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 48 && c <= 57) {
                sb.append(c);
                dfs(res, s, sb, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(Character.toLowerCase(c));
                dfs(res, s, sb, i + 1);
                sb.deleteCharAt(sb.length() - 1);

                sb.append(Character.toUpperCase(c));
                dfs(res, s, sb, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2"));
        System.out.println(new LetterCasePermutation().letterCasePermutation2("a1b2"));
    }
}
