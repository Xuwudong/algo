package com.xwd.meeting;

/**
 * 有一个各种重量的数组a[i]，一个背包空间G, 选出一个序列使得背包剩余空间最小并返回最小剩余空间。
 */
public class ByteDance2 {

    public static void main(String[] args) {
        ByteDance2 main = new ByteDance2();
        System.out.println(main.rest(new int[]{1, 3, 4, 20, 2}, 19));
    }

    public int rest(int[] arr, int total) {
        boolean[][] dp = new boolean[arr.length][total + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        if (arr[0] < total + 1) {
            dp[0][arr[0]] = true;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < total + 1; j++) {
                // 不选arr[i]
                dp[i][j] = dp[i - 1][j];
                // 只选arr[i]
                if (arr[i] == j) {
                    dp[i][j] = true;
                }
                // 选arr[i]加上前面的可能序列
                for (int k = 0; k < j; k++) {
                    if (dp[i - 1][k] && k + arr[i] == j) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }
        for (int j = total; j >= 0; j--) {
            if (dp[arr.length - 1][j]) {
                return total - j;
            }
        }
        return total;
    }
}
