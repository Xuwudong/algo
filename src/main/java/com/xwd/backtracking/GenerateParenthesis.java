package com.xwd.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        generate(res, s, 0, 0, n);
        return res;
    }

    private void generate(List<String> res, StringBuilder s, int open, int close, int max) {
        if (s.length() == max * 2) {
            res.add(s.toString());
            return;
        }
        if (open < max) { // 注意是小于max
            s.append('(');
            generate(res, s, open + 1, close, max);
            s.deleteCharAt(s.length() - 1);
        }
        if (close < open) {
            s.append(')');
            generate(res, s, open, close + 1, max);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
