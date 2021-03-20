package com.xwd.backtracking.expamd;


import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        generate(res, s, 0, 0, n);
        return res;
    }

    private void generate(List<String> res, StringBuilder s, int open, int close, int n) {
        if (s.length() == 2 * n) {
            res.add(s.toString());
            return;
        }
        if (open < n) {
            s.append("(");
            generate(res, s, open + 1, close, n);
            s.deleteCharAt(s.length() - 1);
        }
        if (close < open) {
            s.append(")");
            generate(res, s, open, close + 1, n);
            s.deleteCharAt(s.length() - 1);
        }
    }


    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        List<String> list = g.generateParenthesis(3);
        System.out.println(list);
    }
}
