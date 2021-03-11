package com.xwd.backtracking;

/**
 * @program: algo
 * @description: 357
 * @author: xuwudong
 * @create: 2021-03-13 17:31
 **/
public class CountNumberWithUniqueDigits {

    public int countNumberWithUniqueDigits(int n) {
        return dfs(n, 0, new boolean[10]);
    }

    public int countNumberWithUniqueDigits2(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int first = 10;
        int second = 9 * 9;
        for (int i = 2; i <= n; i++) {
            first = first + second;
            second = second * (10 - i);
        }
        return first;
    }

    private int dfs(int n, int index, boolean[] used) {
        int count = 0;
        if (index != n) {
            for (int i = 0; i <= 9; i++) {
                if (i == 0 && index == 1 && n > 1) {
                    continue;
                }
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                count += dfs(n, index + 1, used) + 1;
                used[i] = false;
            }
        }
        return count;

    }


    public static void main(String[] args) {
        System.out.println(new CountNumberWithUniqueDigits().countNumberWithUniqueDigits(2));
        System.out.println(new CountNumberWithUniqueDigits().countNumberWithUniqueDigits2(2));
    }


}
