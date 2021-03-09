package com.xwd.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinations {
    private static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.equals("")) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs(sb, res, 0, digits);
        return res;
    }

    private void dfs(StringBuilder sb, List<String> res, int index, String digits) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String value = map.get(digits.charAt(index) - 48);
        for (int i = 0; i < value.length(); i++) {
            sb.append(value.charAt(i));
            dfs(sb, res, index + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations l = new LetterCombinations();
        List<String> list = l.letterCombinations("234");
        System.out.println(list);
    }
}
