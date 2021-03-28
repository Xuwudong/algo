package com.xwd.stack;

import java.util.Stack;

//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
//
// 整数除法仅保留整数部分。
//
//
//
//
//
// 示例 1：
//
//
//输入：s = "3+2*2"
//输出：7
//
//
// 示例 2：
//
//
//输入：s = " 3/2 "
//输出：1
//
//
// 示例 3：
//
//
//输入：s = " 3+5 / 2 "
//输出：5
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 3 * 105
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
// s 表示一个 有效表达式
// 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
// 题目数据保证答案是一个 32-bit 整数
//
//
//
// Related Topics 栈 字符串
// 👍 367 👎 0



/**
 * @program: algo
 * @description:
 * @author: xuwudong
 * @create: 2021-03-30 17:00
 **/
public class Calculate {
    public int calculate(String s) {
        java.util.Stack<Integer> stack = new Stack<>();
        int nums = 0;
        char preSigh = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 48 && c <= 57) {
                nums = nums * 10 + c - 48;
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (preSigh) {
                    case '+':
                        stack.push(nums);
                        break;
                    case '-':
                        stack.push(-nums);
                        break;
                    case '*':
                        stack.push(stack.pop() * nums);
                        break;
                    case '/':
                        stack.push(stack.pop() / nums);
                        break;
                }
                preSigh = c;
                nums = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculate("3+2*2"));
    }
}
