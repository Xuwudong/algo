package com.xwd.backtracking.incomingline;

/**
 * 306. 累加数
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 *
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 * 示例 1:
 *
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2:
 *
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 * @program: algo
 * @description: 306
 * @author: xuwudong
 * @create: 2021-03-11 17:09
 **/
public class IsAdditiveNumber {

    private String s;

    private int n;

    public boolean isAdditiveNumber(String num) {
        s = num;
        n = s.length();
        return dfs(0, 0, 0, 0);
    }

    /**
     *
     * @param index 下标
     * @param sum 前两个数之和
     * @param previous 前一个数
     * @param count 已经添加的个数
     * @return
     */
    private boolean dfs(int index, long sum, long previous, int count) {
        if (index == n) {
            if (count >= 3) {
                return true;
            }
        }
        // value值用于累加值
        long value = 0;
        for (int i = index; i < n; i++) {
            // 第一个数是0，而且当前value大于一位，直接break
            if (i > index && s.charAt(index) == '0') {
                break;
            }
            value = value * 10 + s.charAt(i) - '0';
            if (count >= 2) {
                if (value < sum) {
                    // 继续累加value
                    continue;
                } else if (value > sum) {
                    // 累加value无意义，直接break
                    break;
                }
            }
            // 忽略false结果，妙！
            if (dfs(i + 1, previous + value, value, count + 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsAdditiveNumber().isAdditiveNumber("11235813"));
        System.out.println(new IsAdditiveNumber().isAdditiveNumber("0123"));
        System.out.println(new IsAdditiveNumber().isAdditiveNumber("101"));
        System.out.println(new IsAdditiveNumber().isAdditiveNumber("111"));
        System.out.println(new IsAdditiveNumber().isAdditiveNumber("112358"));
        System.out.println(new IsAdditiveNumber().isAdditiveNumber("112357"));
        System.out.println(new IsAdditiveNumber().isAdditiveNumber("199100199"));
        System.out.println(new IsAdditiveNumber().isAdditiveNumber("199100198"));
//        System.out.println(new IsAdditiveNumber().isAdditiveNumber("12012122436"));
        System.out.println(Long.MAX_VALUE);
    }
}
