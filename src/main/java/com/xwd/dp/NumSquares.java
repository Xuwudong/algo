package com.xwd.dp;

import java.util.Arrays;

/**
 * @Author LXT
 * @create 2021/5/3 16:06
 */
public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int squareSize = (int)Math.sqrt(n) + 1;
        int[] squereNum = new int[squareSize];
        for(int i = 1;i< squareSize;i++) {
            squereNum[i] = i * i;
        }
        for (int i = 1;i<=n;i++) {
            for (int s = 1;s<squareSize;s++) {
                if (i < squereNum[s]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - squereNum[s]] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares main = new NumSquares();
        System.out.println(main.numSquares(12));
    }
}
