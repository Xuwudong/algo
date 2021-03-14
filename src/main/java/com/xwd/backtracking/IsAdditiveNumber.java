package com.xwd.backtracking;

/**
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
            // 忽略false结果,等于 a || b 的逻辑，妙！
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
