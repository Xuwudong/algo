package com.xwd.stack;

import java.util.Stack;

/**
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 *
 * 请注意，返回的 规范路径 必须遵循下述格式：
 *
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：path = "/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 *
 * 输入：path = "/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
 * 示例 3：
 *
 * 输入：path = "/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 示例 4：
 *
 * 输入：path = "/a/./b/../../c/"
 * 输出："/c"
 *
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<Character> stack = new Stack<>();
        int pointCount = 0;
        boolean start = false;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                while (!stack.isEmpty() && stack.peek() == '/') {
                    stack.pop();
                }
                stack.push(c);
                pointCount = 0;
                start = true;
            } else if (c == '.') {
                if (start) {
                    pointCount++;
                    if (pointCount == 1) {
                        if (i + 1 < path.length() && path.charAt(i + 1) != '/') {
                            stack.push(c);
                        } else {
                            // 一个点回退
                            if (stack.size() > 1) {
                                stack.pop();
                            }
                        }
                    } else if (pointCount == 2) {
                        if (i + 1 < path.length() && path.charAt(i + 1) != '/') {
                            stack.push(c);
                        } else {
                            // 两个点回退，
                            stack.pop();
                            stack.pop();
                            while (!stack.isEmpty()) {
                                if (stack.peek() != '/') {
                                    stack.pop();
                                } else {
                                    stack.pop();
                                    break;
                                }
                            }
                        }
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }

            } else {
                stack.push(c);
                pointCount = 0;
                start = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String res = sb.reverse().toString();
        if (res.length() > 1 && res.charAt(res.length() - 1) == '/') {
            res = res.substring(0, res.length() - 1);
        }
        if (res.equals("")) {
            res = "/";
        }
        return res;
    }

    public static void main(String[] args) {
        SimplifyPath path = new SimplifyPath();
        System.out.println(path.simplifyPath("/hello../world"));
    }
}
