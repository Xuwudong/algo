package com.xwd.divide.and.conquer;

import java.util.ArrayList;
import java.util.List;

//给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 *
// 。
//
// 示例 1:
//
// 输入: "2-1-1"
//输出: [0, 2]
//解释:
//((2-1)-1) = 0
//(2-(1-1)) = 2
//
// 示例 2:
//
// 输入: "2*3-4*5"
//输出: [-34, -14, -10, -10, 10]
//解释:
//(2*(3-(4*5))) = -34
//((2*3)-(4*5)) = -14
//((2*(3-4))*5) = -10
//(2*((3-4)*5)) = -10
//(((2*3)-4)*5) = 10
// Related Topics 分治算法
// 👍 357 👎 0




/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-04-08 14:52
 **/
public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String expression) {
        if (expression.length() == 0) {
            return new ArrayList<>();
        }
        int index = 0;
        int num = 0;
        while (index < expression.length() && !isOperator(expression.charAt(index))) {
            num = num * 10 + expression.charAt(index) - 48;
            index++;
        }
        List<Integer> res = new ArrayList<>();
        if (index == expression.length()) {
            res.add(num);
            return res;
        }
        for (int i = 0; i < expression.length(); i++) {
            if (isOperator(expression.charAt(i))) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        res.add(operator(left.get(j), expression.charAt(i), right.get(k)));
                    }
                }
            }
        }
        return res;
    }


    private int operator(int l, char c, int r) {
        switch (c) {
            case '+':
                return l + r;
            case '-':
                return l - r;
            case '*':
                return l * r;
        }
        return 0;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }

    public static void main(String[] args) {
        DiffWaysToCompute main = new DiffWaysToCompute();
        System.out.println(main.diffWaysToCompute("2-1-1"));
    }
}
